package by.it.academy.dao;

import by.it.academy.beans.User;
import by.it.academy.exeptions.DAOException;

public interface DAOUser {

    void registrationNewUser(User user) throws DAOException;
    User authorizationUser(String login,String password) throws DAOException;
}
