package by.it.academy.controller.impl.user_command;

import by.it.academy.bean.User;
import by.it.academy.controller.Command;
import by.it.academy.service.ServiceProvider;
import by.it.academy.service.UserService;
import by.it.academy.service.exeption.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class UpdateUser implements Command {

    private static final Logger log = LogManager.getLogger(UpdateUser.class);
    private static final UserService userService = ServiceProvider.getInstance().getUserService();
    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    private static final String SESSION_ATTRIBUTE_USER_ID = "userId";
    private static final String REQUEST_PARAMETER_USER_NAME = "name";
    private static final String REQUEST_PARAMETER_USER_SURNAME = "surname";
    private static final String REQUEST_PARAMETER_USER_EMAIL = "email";
    private static final String REQUEST_PARAMETER_USER_PASSWORD = "password";
    private static final String GO_TO_USER_PAGE = "Controller?command=GO_TO_USER_PAGE";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Integer userId = (Integer) session.getAttribute(SESSION_ATTRIBUTE_USER_ID);
        String name=request.getParameter(REQUEST_PARAMETER_USER_NAME);
        String surname=request.getParameter(REQUEST_PARAMETER_USER_SURNAME);
        String email=request.getParameter(REQUEST_PARAMETER_USER_EMAIL);
        String password=request.getParameter(REQUEST_PARAMETER_USER_PASSWORD);
        try {
            if (userService.updateUserInfo(new User(userId,name,surname,email,password))) {
                response.sendRedirect(GO_TO_USER_PAGE);
            } else response.sendRedirect(PATH_AFTER_EXCEPTION);
        } catch (ServiceException e) {
            log.error("Update user profile exception.", e);
            response.sendRedirect(PATH_AFTER_EXCEPTION);
        }
    }
}
