package by.it.rudakova.jd01_15;

public class RepositoryEcxception extends Exception{
    public RepositoryEcxception() {
    }

    public RepositoryEcxception(String message) {
        super(message);
    }

    public RepositoryEcxception(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryEcxception(Throwable cause) {
        super(cause);
    }
}
