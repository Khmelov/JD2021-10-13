package by.it.ena.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private static final String LANGUAGE = "by.it.ena.jd02_05.language.strings";

    private ResourceBundle bundle;

    ResourceManager() {
        setLocal(Locale.getDefault());
    }

    public final void setLocal(Locale locale) {
        bundle = ResourceBundle.getBundle(LANGUAGE, locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
