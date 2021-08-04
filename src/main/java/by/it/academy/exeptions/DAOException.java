package by.it.academy.exeptions;

import java.sql.SQLException;
import java.util.Iterator;

public class DAOException extends SQLException {

    public DAOException(String reason, String SQLState, int vendorCode) {
        super(reason, SQLState, vendorCode);
    }

    public DAOException(String reason, String SQLState) {
        super(reason, SQLState);
    }

    public DAOException(String reason) {
        super(reason);
    }

    public DAOException() {
        super();
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String reason, Throwable cause) {
        super(reason, cause);
    }

    public DAOException(String reason, String sqlState, Throwable cause) {
        super(reason, sqlState, cause);
    }

    public DAOException(String reason, String sqlState, int vendorCode, Throwable cause) {
        super(reason, sqlState, vendorCode, cause);
    }

    @Override
    public String getSQLState() {
        return super.getSQLState();
    }

    @Override
    public int getErrorCode() {
        return super.getErrorCode();
    }

    @Override
    public SQLException getNextException() {
        return super.getNextException();
    }

    @Override
    public void setNextException(SQLException ex) {
        super.setNextException(ex);
    }

    @Override
    public Iterator<Throwable> iterator() {
        return super.iterator();
    }
}
