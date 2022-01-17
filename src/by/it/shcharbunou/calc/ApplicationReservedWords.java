package by.it.shcharbunou.calc;

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
