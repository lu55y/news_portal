package by.it.academy.dao.impl;

import by.it.academy.beans.User;
import by.it.academy.dao.DAOUser;
import by.it.academy.exeptions.DAOException;

public class DAOUserImpl implements DAOUser {


    @Override
    public void registrationNewUser(User user) throws DAOException {

    }

    @Override
    public User authorizationUser(String login, String password) throws DAOException {
        return null;
    }
}
