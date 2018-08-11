package org.leesia.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @Auther: leesia
 * @Date: 2018/8/11 13:50
 * @Description:
 */
public class PinYinTool {

    /**
     * 将文字转为汉语拼音
     *
     * @param chineseCharacter 要转成拼音的中文
     */
    public static String toPinYin(String chineseCharacter) {
        char[] characters = chineseCharacter.trim().toCharArray();
        String pinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 输出拼音全部小写
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        try {
            for (int i = 0; i < characters.length; i++) {
                if (String.valueOf(characters[i]).matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音
                    pinyin += PinyinHelper.toHanyuPinyinStringArray(characters[i], defaultFormat)[0];
                } else {// 如果字符不是中文,则不转换
                    pinyin += characters[i];
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("字符不能转成汉语拼音");
        }
        return pinyin;
    }

    public static String getFirstLettersUp(String chineseCharacter) {
        return getFirstLetters(chineseCharacter, HanyuPinyinCaseType.UPPERCASE);
    }

    public static String getFirstLettersLower(String chineseCharacter) {
        return getFirstLetters(chineseCharacter, HanyuPinyinCaseType.LOWERCASE);
    }

    public static String getFirstLetters(String chineseCharacter, HanyuPinyinCaseType caseType) {
        char[] characters = chineseCharacter.trim().toCharArray();
        String pinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(caseType);// 输出拼音全部大写
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
        try {
            for (int i = 0; i < characters.length; i++) {
                String str = String.valueOf(characters[i]);
                if (str.matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母
                    pinyin += PinyinHelper.toHanyuPinyinStringArray(characters[i], defaultFormat)[0].substring(0, 1);
                } else if (str.matches("[0-9]+")) {// 如果字符是数字,取数字
                    pinyin += characters[i];
                } else if (str.matches("[a-zA-Z]+")) {// 如果字符是字母,取字母
                    pinyin += characters[i];
                } else {// 否则不转换
                    pinyin += characters[i];//如果是标点符号的话，带着
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("字符不能转成汉语拼音");
        }
        return pinyin;
    }

    public static String getPinyinString(String chineseCharacter) {
        char[] characters = chineseCharacter.trim().toCharArray();
        String pinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 输出拼音全部大写
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
        try {
            for (int i = 0; i < characters.length; i++) {
                String str = String.valueOf(characters[i]);
                if (str.matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母
                    pinyin += PinyinHelper.toHanyuPinyinStringArray(characters[i], defaultFormat)[0];
                } else if (str.matches("[0-9]+")) {// 如果字符是数字,取数字
                    pinyin += characters[i];
                } else if (str.matches("[a-zA-Z]+")) {// 如果字符是字母,取字母

                    pinyin += characters[i];
                } else {// 否则不转换
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("字符不能转成汉语拼音");
        }
        return pinyin;
    }

    /**
     * 取第一个汉字的第一个字符
     *
     * @return String
     * @throws
     * @Title: getFirstLetter
     * @Description: TODO
     */
    public static String getFirstLetter(String chineseCharacter) {
        char[] characters = chineseCharacter.trim().toCharArray();
        String pinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);// 输出拼音全部大写
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
        try {
            String str = String.valueOf(characters[0]);
            if (str.matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母
                pinyin = PinyinHelper.toHanyuPinyinStringArray(characters[0], defaultFormat)[0].substring(0, 1);
            } else if (str.matches("[0-9]+")) {// 如果字符是数字,取数字
                pinyin += characters[0];
            } else if (str.matches("[a-zA-Z]+")) {// 如果字符是字母,取字母

                pinyin += characters[0];
            } else {// 否则不转换

            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("字符不能转成汉语拼音");
        }
        return pinyin;
    }

    public static void main(String[] args) {
        PinYinTool pinYinTool = new PinYinTool();
        System.out.println(pinYinTool.getFirstLettersUp("多发的发独守空房阿道夫打发第三方"));
    }
}
