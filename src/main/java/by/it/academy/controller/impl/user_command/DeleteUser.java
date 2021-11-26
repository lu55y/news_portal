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

public class DeleteUser implements Command {

    private static final UserService userService = ServiceProvider.getInstance().getUserService();
    private static final String SESSION_ATTRIBUTE_USER_ID = "userId";
    private static final String PATH_AFTER_DELETE_USER = "Controller?command=GO_TO_MAIN_PAGE";
    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    private static final Logger log = LogManager.getLogger(DeleteUser.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Integer userId = (Integer) session.getAttribute(SESSION_ATTRIBUTE_USER_ID);
        try {
            if (userService.deleteUserByID(userId)) {
                session.invalidate();
                response.sendRedirect(PATH_AFTER_DELETE_USER);
            } else response.sendRedirect(PATH_AFTER_EXCEPTION);
        } catch (ServiceException e) {
            log.error("Authorization exception", e);
            response.sendRedirect(PATH_AFTER_EXCEPTION);
        }
    }
}
