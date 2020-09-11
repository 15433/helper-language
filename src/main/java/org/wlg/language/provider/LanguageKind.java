package org.wlg.language.provider;

import java.util.*;

/**
 * 语种 列出一些常见的
 * @author 11838
 */
public class LanguageKind {

    public static final String AUTO = "auto";
    public static final String ZH = "zh";
    public static final String ZH_VAL = "简体中文";
    public static final String EN = "en";
    public static final String EN_VAL = "英文";
    public static final String JP = "jp";
    public static final String JP_VAL = "日语";
    public static final String SPA = "spa";
    public static final String SPA_VAL = "西班牙语";
    public static final String ARA = "ara";
    public static final String ARA_VAL = "阿拉伯语";
    public static final String RU = "ru";
    public static final String RU_VAL = "俄语";
    public static final String PT = "pt";
    public static final String PT_VAL = "葡萄牙语";
    public static final String DE = "de";
    public static final String DE_VAL = "德语";

    public static List<String> list = new ArrayList<>();
    public static Map<String, String> map = new HashMap<>();

    static {
        list.add(ZH);
        list.add(EN);
        list.add(JP);
        list.add(SPA);
        list.add(ARA);
        list.add(RU);
        list.add(PT);
        list.add(DE);
        map.put(ZH, ZH_VAL);
        map.put(EN, EN_VAL);
        map.put(JP, JP_VAL);
        map.put(SPA, SPA_VAL);
        map.put(ARA, ARA_VAL);
        map.put(RU, RU_VAL);
        map.put(PT, PT_VAL);
        map.put(DE, DE_VAL);
    }

    /**
     * 语言转义，比如：zh_CN -> zh ； ja_JP -> jp
     * @param handZeroLang 你的系统的语言code
     * @return 百度需要的语言 code
     */
    public static String getLangKind(String handZeroLang) {
        if (handZeroLang != null) {
            for (String langKind : list) {
                if (Arrays.asList(handZeroLang.split("_")).contains(langKind)
                        || Arrays.asList(handZeroLang.split("_")).contains(langKind.toUpperCase())) {
                    return langKind;
                }
                if (handZeroLang.toLowerCase().contains(langKind)) {
                    return langKind;
                }
            }
        }
        return AUTO;
    }
}
