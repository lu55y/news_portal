package by.it.academy.exeptions;

import java.io.Serial;

public class ConnectionPoolException extends Exception {
    @Serial
    private static final long serialVersionUID = 4023160738492085873L;

    public ConnectionPoolException() {
        super();
    }

    public ConnectionPoolException(String message) {
        super(message);
    }

    public ConnectionPoolException(String message, Exception e) {
        super(message, e);
    }

    public ConnectionPoolException(Exception e) {
        super(e);
    }

}
