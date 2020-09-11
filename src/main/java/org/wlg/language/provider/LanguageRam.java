package org.wlg.language.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11838
 */
public class LanguageRam {

    public static List<LanguageResult> languageResults = new ArrayList<>();

    public static List<LanguageResult> getLanguageResults() {
        return languageResults;
    }

    public static void setLanguageResults(List<LanguageResult> languageResults) {
        LanguageRam.languageResults = languageResults;
    }

    public static void addLanguageResults(LanguageResult languageResult) {
        LanguageRam.languageResults.add(languageResult);
    }

    public static void clear() {
        languageResults.clear();
    }
}
