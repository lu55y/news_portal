package by.it.academy.controller.impl.main_command;

import by.it.academy.bean.User;
import by.it.academy.controller.Command;
import by.it.academy.service.ServiceProvider;
import by.it.academy.service.UserService;
import by.it.academy.service.exeption.ServiceException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Objects;

public class GoToUserPage implements Command {
    public static final String USER_PAGE = "/WEB-INF/jsp/user_page.jsp";
    public static final String SESSION_LAST_URL = "lastUrl";
    public static final String SESSION_LAST_COMMAND = "GO_TO_USER_PAGE";
    private static final String SESSION_USER_ROLE = "userRole";
    private static final String SESSION_USER_ID = "userId";
    private static final String GO_TO_AUTHORIZATION_PAGE = "Controller?command=GO_TO_AUTHORIZATION_PAGE";
    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    private static final String USER_ROLE = "USER";
    private static final Logger log = LogManager.getLogger(GoToAdminPage.class);
    private static final String REQUEST_ATTRIBUTE_USER = "user";
    ServiceProvider serviceProvider = ServiceProvider.getInstance();
    UserService userService= serviceProvider.getUserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.

        HttpSession session = request.getSession(false);
        session.setAttribute(SESSION_LAST_URL, SESSION_LAST_COMMAND);
        String userRole = (String) session.getAttribute(SESSION_USER_ROLE);
        if (!Objects.equals(userRole, USER_ROLE)) {
            response.sendRedirect(GO_TO_AUTHORIZATION_PAGE);
            return;
        }
        try {
            Integer userId = (Integer) session.getAttribute(SESSION_USER_ID);
            System.out.println(userId);
            User userById = userService.findUserById(userId);
            System.out.println(userById);
            if (userById==null){
                response.sendRedirect(PATH_AFTER_EXCEPTION);
                return;
            }
            request.setAttribute(REQUEST_ATTRIBUTE_USER, userById);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(USER_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
            response.sendRedirect(PATH_AFTER_EXCEPTION);
        }

    }
}
