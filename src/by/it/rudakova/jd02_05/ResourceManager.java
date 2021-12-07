package by.it.rudakova.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private static final String LANGUAGE="by.it.rudakova.jd02_05.txt.strings";

    private ResourceBundle bundle;

    ResourceManager(){
        setLocale(Locale.getDefault());
    }

    public final void setLocale(Locale locale){
        bundle=ResourceBundle.getBundle(LANGUAGE,locale);
    }
    public String get(String key){
        return bundle.getString(key);
    }
}
