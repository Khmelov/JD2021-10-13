package by.it.shcharbunou.jd02_05.service;

import java.util.Locale;

public class LocaleService {

    public Locale getLocale(String language) {
        String country = defineCountry(language);
        assert country != null;
        if (country.equals("US")) {
            return Locale.US;
        }
        return new Locale(language, country);
    }

    private String defineCountry(String language) {
        if (language.equals("") || language.equals("en")) {
            return "US";
        }
        if (language.equals("ru")) {
            return "RU";
        }
        if (language.equals("be")) {
            return "BY";
        }
        return null;
    }
}
