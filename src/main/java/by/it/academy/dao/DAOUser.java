package by.it.academy.dao;

import by.it.academy.bean.RegistrationInfo;
import by.it.academy.bean.User;
import by.it.academy.exeptions.DAOException;

import java.util.List;

public interface DAOUser {
    User authorizationUser(String email, String password) throws DAOException;

    boolean create(RegistrationInfo info) throws DAOException;

    List<User> findAll() throws DAOException;

    User findById(Integer id) throws DAOException;

    boolean deleteByID(Integer id) throws DAOException;

    boolean update(User user) throws DAOException;
}
