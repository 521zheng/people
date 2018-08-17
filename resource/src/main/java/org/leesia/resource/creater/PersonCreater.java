package org.leesia.resource.creater;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.service.PersonService;
import org.leesia.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: leesia
 * @Date: 2018/8/18 0:07
 * @Description:
 */
@Service
public class PersonCreater {

    private static final Logger logger = LoggerFactory.getLogger(PersonCreater.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private ProvinceCreater provinceCreater;

    @Autowired
    private CityCreater cityCreater;

    @Autowired
    private SexCreater sexCreater;

    @Autowired
    private BirthdayCreater birthdayCreater;

    @Autowired
    private NationCreater nationCreater;

    @Autowired
    private IdCreater idCreater;

    @Autowired
    private LastNameCreater lastNameCreater;

    @Autowired
    private NameCreater nameCreater;

    public Person creater() {
        logger.info("生成个人信息");

        try {
            String provinceName = provinceCreater.creater();
            String cityName = cityCreater.creater(provinceName);
            int sex = sexCreater.creater();
            String birthday = birthdayCreater.creater();
            String nation = nationCreater.creater();
            String id = idCreater.creater(provinceName, birthday, sex);
            String lastName = lastNameCreater.creater();
            String name = nameCreater.creater(lastName, sex);

            Person person = new Person();
            person.setId(id);
            person.setName(lastName + name);
            person.setSex(sex);
            person.setBirthday(birthday);
            person.setNation(nation);
            person.setRegisterProvince(provinceName);
            person.setRegisterCity(cityName);
            person.setLiveProvince("");
            person.setLiveCity("");
            person.setCreateDatetime(new Date());
            person.setUpdateDatetime(new Date());

            return person;
        } catch (Exception e) {
            logger.error("生成个人信息异常：" + e);
            return null;
        }
    }

    public void validate(Person person) throws Exception {
        if (person == null) {
            throw new Exception("个人信息为空");
        }
        if (StringUtils.isBlank(person.getId())) {
            throw new Exception("ID为空");
        }
        if (StringUtils.isBlank(person.getName())) {
            throw new Exception("Name为空");
        }
        if (person.getSex() == null) {
            throw new Exception("性别为空");
        }
        if (StringUtils.isBlank(person.getBirthday())) {
            throw new Exception("出生日期为空");
        }
        if (StringUtils.isBlank(person.getNation())) {
            throw new Exception("民族为空");
        }
        if (StringUtils.isBlank(person.getRegisterProvince())) {
            throw new Exception("身份证注册省份为空");
        }
        if (StringUtils.isBlank(person.getRegisterCity())) {
            throw new Exception("身份证注册城市为空");
        }
    }

    public void insertDB(Person person) {
        personService.insert(person);
    }
}
