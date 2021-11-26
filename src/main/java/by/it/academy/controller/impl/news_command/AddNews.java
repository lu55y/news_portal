package by.it.academy.controller.impl.news_command;

import by.it.academy.bean.News;
import by.it.academy.controller.Command;
import by.it.academy.service.NewsService;
import by.it.academy.service.ServiceProvider;
import by.it.academy.service.exeption.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Objects;

public class AddNews implements Command {
    private static final Logger log = LogManager.getLogger(AddNews.class);
    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    private static final String MAIN_PAGE = "Controller?command=GO_TO_MAIN_PAGE";
    private static final String GO_TO_AUTHORIZATION_PAGE = "Controller?command=GO_TO_AUTHORIZATION_PAGE";

    private static final ServiceProvider SERVICE_PROVIDER = ServiceProvider.getInstance();
    private static final NewsService NEWS_SERVICE = SERVICE_PROVIDER.getNewsService();
    private static final String SESSION_ATTRIBUTE_USER_ROLE = "userRole";
    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String briefDescription = request.getParameter("briefDescription");
        String content = request.getParameter("content");
        HttpSession session = request.getSession(false);
        String userRole = (String) session.getAttribute(SESSION_ATTRIBUTE_USER_ROLE);
        if (Objects.equals(userRole, ADMIN_ROLE) | Objects.equals(userRole, USER_ROLE)) {
            News offerNews = new News(title, briefDescription, content);
            if (offerNews == null) {
                response.sendRedirect(PATH_AFTER_EXCEPTION);
                return;
            }
            try {
                NEWS_SERVICE.offerNews(offerNews);
                response.sendRedirect(MAIN_PAGE);
            } catch (ServiceException e) {
                log.error(e);
                response.sendRedirect(PATH_AFTER_EXCEPTION);
            }
        } else response.sendRedirect(GO_TO_AUTHORIZATION_PAGE);
    }
}
