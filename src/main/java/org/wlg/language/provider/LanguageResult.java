package org.wlg.language.provider;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 跟据百度翻译返回json构造的对象
 * @author 11838
 */
public class LanguageResult {

    /**
     * 源语言
     */
    private String from;

    /**
     * 目标语言
     */
    private String to;

    /**
     * 结果
     */
    private List<TransResult> trans_result;

    /**
     * 翻译前后内容键值对，按需供其他地方使用
     * key - 翻译前内容
     * value - 翻译后内容
     */
    private Map<String, String> cacheMap = new HashMap<>();

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<TransResult> getTransResult() {
        return trans_result;
    }

    public void setTransResult(List<TransResult> transResult) {
        this.trans_result = transResult;
    }

    public void addMap(Map<String, String> map) {
        cacheMap.putAll(map);
    }

    public void addKeyValue(String key, String value) {
        cacheMap.put(key, value);
    }

    public Map<String, String> getMap() {
        return cacheMap;
    }

    public String getValueByKey(String key) {
        String value = cacheMap.get(key);
        return value != null ? value : key;
    }

    public void clear() {
        cacheMap.clear();
    }

    /**
     * 构建键值对
     */
    public void initCacheMap() {
        if (!CollectionUtils.isEmpty(this.trans_result)) {
            for (TransResult transResult : this.trans_result) {
                cacheMap.put(transResult.getSrc(), transResult.getDst());
            }
        }
    }
}
