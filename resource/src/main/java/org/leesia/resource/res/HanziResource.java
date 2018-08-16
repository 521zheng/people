package org.leesia.resource.res;

import org.leesia.dataio.service.HanziService;
import org.leesia.entity.Hanzi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: leesia
 * @Date: 2018/8/10 13:26
 * @Description:
 */
@Service
public class HanziResource {



    private String[] MALE_PERFECT = new String[]{
            "俊", "泽", "宇", "金", "佳", "清", "立", "铭", "睿", "德", "培", "沛", "鸿", "兆", "祥", "国", "钦", "胜", "骏", "新",
            "琪", "奇", "艺", "小", "亦", "宝", "光", "浚", "泰", "政", "庆", "宗", "欣", "灏", "轶", "怀", "宁", "禹", "超", "诚",
            "敬", "源", "舒", "凌", "豪", "添", "如", "汉", "心", "沁", "祺", "育", "仕", "自", "权", "祖", "凡", "高", "骐", "朋",
            "泳", "邦", "亚", "森", "照", "烨", "斌", "渝", "人", "城", "璟", "颢", "洛", "淳", "达", "肖", "语", "于", "垚", "岚",
            "紫", "烁", "捷", "上", "予", "铮", "琛", "湘", "雅", "杭", "梁", "红", "在", "灵", "声", "蔚", "积", "真", "武", "笑",
            "旻", "法", "欢", "百", "从", "业", "琨", "植", "丞", "牛", "晧", "奂", "绪", "乙", "民", "镜", "虹", "毓", "子", "浩"
    };

    private String[] FEMALE_PERFECT = new String[]{
            "佳", "怡", "雨", "欣", "子", "诗", "琳", "奕", "楚", "梓", "清", "丽", "惠", "晓", "玲", "紫", "倩", "小", "颖", "曼",
            "舒", "玥", "乐", "璐", "春", "宇", "琪", "琦", "芷", "希", "悦", "俊", "可", "妙", "昕", "锦", "凌", "安", "君", "语",
            "智", "飞", "凡", "燕", "沁", "艳", "千", "桂", "芯", "琬", "玺", "意", "阳", "朝", "育", "益", "恬", "斯", "煜", "溪",
            "誉", "景", "会", "炜", "元", "德", "晶", "相", "霖", "蕙", "治", "中", "汝", "祺", "成", "长", "棠", "曦", "珈", "咏",
            "慕", "培", "宏", "知", "启", "影", "好", "峻", "琴", "来", "园", "荟", "汶", "卉", "萱", "微", "桐", "良", "萧", "世",
            "昀", "上", "霄", "宗", "锐", "程", "丝", "煦", "光", "耀", "周", "彧", "顺", "银", "翊", "信", "黎", "蓉", "瀚", "少"
    };

    @Autowired
    private HanziService hanziService;

    private List<Hanzi> createAllHanzi() throws Exception {
        List<String> noExists = new ArrayList<>();
        List<Hanzi> hanzis = new ArrayList<>();
        Map<String, Hanzi> map = new HashMap<>();
        for (String hanziName : org.leesia.resource.res.Hanzi.getHANZIS()) {
            Hanzi hanzi = new Hanzi();
            hanzi.setHanzi(hanziName);
            hanzis.add(hanzi);
            if (map.containsKey(hanziName)) {
                throw new Exception("汉字重复：" + hanziName);
            }
            map.put(hanziName, hanzi);
        }

        for (String name : NameHanzi.getNAMES()) {
            if (map.containsKey(name)) {
                map.get(name).setIsName(true);
            } else {
                noExists.add(name);
            }
        }
        for (String name : MALE_PERFECT) {
            if (map.containsKey(name)) {
                map.get(name).setMalePerfect(true);
            } else {
                noExists.add(name);
            }
        }
        for (String name : FEMALE_PERFECT) {
            if (map.containsKey(name)) {
                map.get(name).setFemalePerfect(true);
            } else {
                noExists.add(name);
            }
        }

        if (!noExists.isEmpty()) {
            throw new Exception("汉字不存在：" + noExists.toString());
        }
        return hanzis;
    }

    public void insertAllHanzi() throws Exception {
        hanziService.batchInsert(createAllHanzi());
    }
}
