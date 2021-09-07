package by.it.academy.listener;

import by.it.academy.dao.config.ConnectionPool;
import by.it.academy.exeptions.ConnectionPoolException;
import by.it.academy.exeptions.DriverException;
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
