package org.wlg.language.provider;

/**
 * 通用翻译
 * @author 11838
 */
public interface TransLanguage {

    /**
     * 翻译
     *
     * @param content 内容
     * @param from    从什么语言
     * @param to      翻译到什么语言
     * @return 翻译后
     */
    String transLanguage(String content, String from, String to);
}
