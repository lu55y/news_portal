package by.it.academy.exeption;

import java.io.Serial;

public class DAOException extends Exception {

    @Serial
    private static final long serialVersionUID = 3093326465142880470L;

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }

    public DAOException(Exception e) {
        super(e);
    }
}
