package org.leesia.resource.service;

import org.leesia.dataio.service.PersonService;
import org.leesia.entity.Person;
import org.leesia.resource.creater.PersonCreater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: leesia
 * @Date: 2018/8/18 0:30
 * @Description:
 */
@Service
public class PersonCreateService {

    private static final Logger logger = LoggerFactory.getLogger(PersonCreateService.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonCreater personCreater;

    private ExecutorService executor = Executors.newFixedThreadPool(10);

    private void createAndSave(int total, int batchCount) {
        List<Person> persons = new ArrayList<>();

        int count = 0;
        while (count < total) {
            try {
                Person person = createPerson();
                if (person != null) {
                    persons.add(person);
                    count++;

                    if (persons.size() >= batchCount) {
                        personService.batchInsert(persons);
                        persons.clear();

                        logger.info("生成并保存个人信息，已添加：{}", count);
                    }
                }

//                Thread.sleep(100);
            } catch (Exception e) {
                logger.error("生成并保存个人信息失败：" + e);
            }
        }

        if (persons.size() > 0) {
            personService.batchInsert(persons);
            persons.clear();

            logger.info("生成并保存个人信息，已添加：{}", count);
        }
    }

    private Person createPerson() {
        try {
            Person person = personCreater.creater();
            personCreater.validate(person);
            return person;
        } catch (Exception e) {
            logger.error("生成个人信息异常：" + e);
        }
        return null;
    }

    private Runnable getCreateThread(final int total, final int batchCount) {
        return new Runnable() {
            public void run() {
                createAndSave(total, batchCount);
            }
        };
    }

    public void create(int total, int batchCount) {
        executor.execute(getCreateThread(total, batchCount));
    }
}
