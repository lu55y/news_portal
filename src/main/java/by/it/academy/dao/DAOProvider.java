package by.it.academy.dao;

import by.it.academy.dao.impl.DAONewsImpl;
import by.it.academy.dao.impl.DAOUserImpl;

public class DAOProvider {
    public static final DAOProvider INSTANCE = new DAOProvider();
    private final DAOUser daoUser = new DAOUserImpl();
    private final DAONews daoNews = new DAONewsImpl();

    public DAOProvider() {
    }

    public static DAOProvider getINSTANCE() {
        return INSTANCE;
    }

    public DAOUser getDaoUser() {
        return daoUser;
    }

    public DAONews getDaoNews() {
        return daoNews;
    }
}
