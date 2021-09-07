package by.it.academy.exeption;

import java.io.Serial;

public class ServiceException extends Exception{
    @Serial
    private static final long serialVersionUID = -2545176754559216684L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }
}
