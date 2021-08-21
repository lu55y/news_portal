package by.it.academy.exeptions;

import java.io.Serial;

public class DriverException extends ClassNotFoundException {
    @Serial
    private static final long serialVersionUID = -5286035967487279204L;

    public DriverException() {
        super();
    }

    public DriverException(String s) {
        super(s);
    }

    public DriverException(String s, Exception ex) {
        super(s, ex);
    }

}
