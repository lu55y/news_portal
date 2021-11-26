package by.it.academy.service.impl;

import by.it.academy.bean.RegistrationInfo;
import by.it.academy.bean.User;
import by.it.academy.dao.DAOProvider;
import by.it.academy.dao.DAOUser;
import by.it.academy.dao.exeption.DAOException;
import by.it.academy.service.exeption.ServiceException;
import by.it.academy.service.UserService;
import by.it.academy.service.validator.UserAuthorizationValidator;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final UserAuthorizationValidator validation=new UserAuthorizationValidator();
    private static final DAOProvider daoProvider = DAOProvider.getINSTANCE();
    private static final DAOUser daoUser = daoProvider.getDaoUser();

    @Override
    public boolean newUserRegistration(RegistrationInfo info) throws ServiceException {
//        boolean validate = validation.validate(info);
//        if (validate) {
//            try {
//                return daoUser.create(info);
//            } catch (DAOException e) {
//                throw new ServiceException(e);
//            }
//        }
//        System.out.println("bad validation");
//        return false;
        try {
            return daoUser.create(info);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User authorizationUser(RegistrationInfo info) throws ServiceException {
        try {
            return daoUser.authorizationUser(info);
        } catch (DAOException e) {
            throw new ServiceException("User authorization exception",e);
        }
        /*        boolean validate = validation.validate(email, password);
        if (validate) {
            try {
                return daoUser.authorizationUser(email, password);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }
        System.out.println("bad validation");
        return null;*/
    }

    @Override
    public List<User> findAllUsers() throws ServiceException {
        try {
            return daoUser.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User findUserById(Integer id) throws ServiceException {
        try {
            return daoUser.findById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteUserByID(Integer id) throws ServiceException {
        try {
            return daoUser.deleteByID(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateUserInfo(User user) throws ServiceException {
        try {
            return daoUser.update(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
