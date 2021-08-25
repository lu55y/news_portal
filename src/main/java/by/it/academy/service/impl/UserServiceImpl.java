package by.it.academy.service.impl;

import by.it.academy.bean.RegistrationInfo;
import by.it.academy.bean.User;
import by.it.academy.exeptions.ServiceException;
import by.it.academy.service.UserService;
import by.it.academy.service.validator.Validation;

public class UserServiceImpl implements UserService {

    private static final Validation validation=new Validation();

    @Override
    public User newUserRegistration(RegistrationInfo info) throws ServiceException {
        return null;
    }

    @Override
    public User userAuthorization(RegistrationInfo info) throws ServiceException {
        boolean chekValidation = validation.validate(info);

        if(chekValidation){
            return null;
        }
        return null;

    }
}
