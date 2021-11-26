package by.it.academy.controller.impl.main_command;

import by.it.academy.controller.Command;
import by.it.academy.service.NewsService;
import by.it.academy.service.ServiceProvider;
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

public class GoToAdminPage implements Command {
    private static final Logger log = LogManager.getLogger(GoToAdminPage.class);
    ServiceProvider serviceProvider = ServiceProvider.getInstance();
    NewsService newsService = serviceProvider.getNewsService();

    private static final String ADMIN_PAGE = "/WEB-INF/jsp/admin_page.jsp";
    private static final String GO_TO_AUTHORIZATION_PAGE = "Controller?command=GO_TO_AUTHORIZATION_PAGE";
    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    public static final String SESSION_LAST_URL = "lastUrl";
    public static final String SESSION_LAST_COMMAND = "Controller?command=GO_TO_ADMIN_PAGE";
    private static final String SESSION_USER_ROLE = "userRole";
    private static final String ALL_NEWS = "allNews";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//        response.setDateHeader("Expires", 0); // Proxies.

        HttpSession session = request.getSession(false);
        session.setAttribute(SESSION_LAST_URL, SESSION_LAST_COMMAND);
        String userRole = (String) session.getAttribute(SESSION_USER_ROLE);
        if (Objects.equals(userRole, "ADMIN")) {
            try {
                request.setAttribute(ALL_NEWS, newsService.findAllNews());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(ADMIN_PAGE);
                requestDispatcher.forward(request, response);
            } catch (ServiceException e) {
                log.error("Database error while loading news", e);
                response.sendRedirect(PATH_AFTER_EXCEPTION);
            }
        } else response.sendRedirect(GO_TO_AUTHORIZATION_PAGE);
    }
}
