package org.wlg.language.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 百度实现类
 * @author 11838
 */
@Component
public class TransLanguageImpl implements TransLanguage {

    // 本地main方法测试时，注意 appId securityKey 给值
    private static String appId = "20200903000558109";
    private static String securityKey = "STrNGPlS7gf3_XvPTB_v";

    // 如果集成到服务中，这里换成appId securityKey实际的值，也可以在配置文件中配置
    @Value("${language.baidu.appId:xxxx}")
    private void setAppId(String appId) {
        TransLanguageImpl.appId = appId;
    }
    @Value("${language.baidu.securityKey:xxxx}")
    private void setSecurityKey(String securityKey) {
        TransLanguageImpl.securityKey = securityKey;
    }

    @Override
    public String transLanguage(String content, String from, String to) {
        // from , to处理
        from = LanguageKind.getLangKind(from);
        to = LanguageKind.getLangKind(to);
        TransApi api = new TransApi(appId, securityKey);
        return api.getTransResult(content, from, to);
    }

    /**
     * 把原始字符串分割成指定长度的字符串列表
     *
     * @param inputString
     *            原始字符串
     * @param length
     *            指定长度
     * @return
     */
    public static List<String> getStrList(String inputString, int length) {
        int size = inputString.length() / length;
        if (inputString.length() % length != 0) {
            size += 1;
        }
        return getStrList(inputString, length, size);
    }

    /**
     * 把原始字符串分割成指定长度的字符串列表
     *
     * @param inputString
     *            原始字符串
     * @param length
     *            指定长度
     * @param size
     *            指定列表大小
     * @return
     */
    public static List<String> getStrList(String inputString, int length,
                                          int size) {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < size; index++) {
            String childStr = substring(inputString, index * length,
                    (index + 1) * length);
            list.add(childStr);
        }
        return list;
    }

    /**
     * 分割字符串，如果开始位置大于字符串长度，返回空
     *
     * @param str
     *            原始字符串
     * @param f
     *            开始位置
     * @param t
     *            结束位置
     * @return
     */
    public static String substring(String str, int f, int t) {
        if (f > str.length()) {
            return null;
        }
        if (t > str.length()) {
            return str.substring(f);
        } else {
            return str.substring(f, t);
        }
    }
}
