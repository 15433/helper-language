package org.wlg.language.provider;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author 11838
 */
public class TransApi {
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";
    // get请求query长度的限制值，再大会导致http请求414
    private static final int QUERY_LENGTH = 1000;
    // 百度翻译每次接口请求query支持的最大词数量， 官方文档上说是大约2000，实际多次测试最高大约4400，这里设置4000，利用率最大化
    public static final int QUERY_MAX_LENGTH = 4000;
    private String appId;
    private String securityKey;

    public TransApi(String appId, String securityKey) {
        this.appId = appId;
        this.securityKey = securityKey;
    }

    public String getTransResult(String query, String from, String to) {
        Map<String, String> params = buildParams(query, from, to);
        if (query.length() > QUERY_LENGTH) {
            return HttpPostRequest.doPostStr(TRANS_API_HOST, params);
        }
        return HttpGet.get(TRANS_API_HOST, params);
    }

    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appId);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        System.out.println("salt:" + salt);
        params.put("salt", salt);

        // 签名
        String src = appId + query + salt + securityKey; // 加密前的原文
        params.put("sign", MD5.md5(src));

        return params;
    }

    /**
     * 是否只包含数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        String rex = "[0-9]*";
        Pattern pattern = Pattern.compile(rex);
        return pattern.matcher(str).matches();
    }
}
