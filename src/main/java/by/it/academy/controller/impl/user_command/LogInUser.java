package by.it.academy.controller.impl.user_command;

import by.it.academy.bean.RegistrationInfo;
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

public class LogInUser implements Command {

    private static final UserService userService= ServiceProvider.getInstance().getUserService();

    private static final String REQUEST_PARAMETER_EMAIL = "email";
    private static final String REQUEST_PARAMETER_PASSWORD = "password";
    private static final String SESSION_ATTRIBUTE_USER_ID = "userId";
    private static final String SESSION_ATTRIBUTE_USER_ROLE = "userRole";
    private static final String PATH_AFTER_AUTHORIZATION = "Controller?command=GO_TO_MAIN_PAGE";
    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    private static final  Logger log= LogManager.getLogger(LogInUser.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email= request.getParameter(REQUEST_PARAMETER_EMAIL);
        String password = request.getParameter(REQUEST_PARAMETER_PASSWORD);
        RegistrationInfo info = new RegistrationInfo(email,password);
        try {
            User user = userService.authorizationUser(info);
            if (user==null){
                response.sendRedirect("Controller?command=go_to_authorization_page");
                return;
            }
            HttpSession session = request.getSession(false);
            session.setAttribute(SESSION_ATTRIBUTE_USER_ID, user.getId());
            System.out.println(user.getId());
            session.setAttribute(SESSION_ATTRIBUTE_USER_ROLE, user.getRole());
            response.sendRedirect(PATH_AFTER_AUTHORIZATION);
        } catch (ServiceException e) {
            log.error("Authorization exception", e);
            response.sendRedirect(PATH_AFTER_EXCEPTION);
        }
    }
}
