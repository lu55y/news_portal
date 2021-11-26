package by.it.academy.listener;

import by.it.academy.dao.config.ConnectionPool;
import by.it.academy.dao.exeption.ConnectionPoolException;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ConnectionPoolListener implements ServletContextListener {
    private ConnectionPool pool;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        pool = ConnectionPool.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            pool.dispose();
        } catch (ConnectionPoolException e) {
            //log
        }
    }
}
