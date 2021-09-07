package by.it.academy.listener;

import by.it.academy.dao.config.ConnectionPool;
import by.it.academy.dao.exeption.ConnectionPoolException;
import by.it.academy.dao.exeption.DriverException;
import jakarta.servlet.ServletContextListener;

public class ConnectionPoolListener implements ServletContextListener {
    public void contextInitialized() throws ConnectionPoolException {
        ConnectionPool connectionPool=ConnectionPool.getInstance();
        try {
            connectionPool.initPoolData();
        } catch (ConnectionPoolException | DriverException e) {
            //log
            throw new ConnectionPoolException("Connection poll initialize error:",e);
        }
    }

}
