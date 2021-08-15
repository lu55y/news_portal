package by.it.academy.dao;

import by.it.academy.dao.impl.DAONewsImpl;
import by.it.academy.dao.impl.DAOUserImpl;

import java.sql.Connection;

public class DaoProvider {
    public static final DaoProvider INSTANCE = new DaoProvider();
    private final DaoUser daoUser = new DAOUserImpl();
    private final DaoNews daoNews = new DAONewsImpl();

    public DaoProvider() {
    }

    public static DaoProvider getINSTANCE() {
        return INSTANCE;
    }

    public DaoUser getDaoUser() {
        return daoUser;
    }

    public DaoNews getDaoNews() {
        return daoNews;
    }
}
