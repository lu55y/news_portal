package by.it.academy.dao;

import by.it.academy.bean.RegistrationInfo;
import by.it.academy.bean.User;
import by.it.academy.exeptions.DAOException;

public interface DAOUser extends Dao<Integer,User> {

    void registrationNewUser(RegistrationInfo info) throws DAOException;
    User authorizationUser(String login,String password) throws DAOException;
}
