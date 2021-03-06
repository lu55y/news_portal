package by.it.academy.service;

import by.it.academy.bean.RegistrationInfo;
import by.it.academy.bean.User;
import by.it.academy.service.exeption.ServiceException;

import java.util.List;

public interface UserService {

    boolean newUserRegistration(RegistrationInfo info) throws ServiceException;

    User authorizationUser(RegistrationInfo info) throws ServiceException;

    List<User> findAllUsers() throws ServiceException;

    User findUserById(Integer id) throws ServiceException;

    boolean deleteUserByID(Integer id) throws ServiceException;

    boolean updateUserInfo(User user) throws ServiceException;
}
