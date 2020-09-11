# helper-language
语言翻译，使用百度翻译api，各种坑已踩

## 可扩展
百度翻译实现类 TransLanguageImpl实现通过翻译方法 
```
    /**
     * 翻译
     *
     * @param content 内容
     * @param from    从什么语言
     * @param to      翻译到什么语言
     * @return 翻译后
     */
    String transLanguage(String content, String from, String to);
```

## 例子 MyClient

例子中展示了较为实际的翻译场景，大数据/批量翻译
