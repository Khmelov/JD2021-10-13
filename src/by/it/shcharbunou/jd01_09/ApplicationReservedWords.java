package by.it.shcharbunou.jd01_09;

public enum ApplicationReservedWords {
    END("end");

    private final String applicationReservedWord;

    public String getApplicationReservedWord() {
        return applicationReservedWord;
    }

    ApplicationReservedWords(String applicationReservedWord) {
        this.applicationReservedWord = applicationReservedWord;
    }
}
