package org.wlg.language.provider;

/**
 * @author 11838
 */
public class TransResult {

    /**
     * 原本内容
     */
    private String src;

    /**
     * 翻译后内容
     */
    private String dst;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }
}
