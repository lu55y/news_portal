package by.it.academy.service;

import by.it.academy.beans.RegistrationInfo;
import by.it.academy.beans.User;
import by.it.academy.exeptions.ServiceException;

public interface UserService {

    User newUserRegistration(RegistrationInfo info) throws ServiceException;
    User userAuthorization(RegistrationInfo info) throws ServiceException;
}
