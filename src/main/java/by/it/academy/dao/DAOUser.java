package by.it.academy.dao;

import by.it.academy.beans.RegistrationInfo;
import by.it.academy.beans.User;
import by.it.academy.exeptions.DAOException;

public interface DaoUser extends Dao<Long,User> {

    void registrationNewUser(RegistrationInfo info) throws DAOException;
    User authorizationUser(String login,String password) throws DAOException;
}
