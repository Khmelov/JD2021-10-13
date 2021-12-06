package by.it.antipov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    MANAGER;
    private static final String lang = "by.it.antipov.jd02_05.strings";
    private ResourceBundle resourceBundle;
    ResourceManager() {
        setLocal(Locale.getDefault());
    }

    public final void setLocal(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(lang, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }


}


