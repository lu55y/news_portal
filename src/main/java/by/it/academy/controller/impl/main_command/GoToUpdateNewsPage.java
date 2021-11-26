package by.it.academy.controller.impl.main_command;

import by.it.academy.bean.News;
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

public class GoToUpdateNewsPage implements Command {
    private static final Logger log = LogManager.getLogger(GoToUpdateNewsPage.class);

    private static final String GO_TO_UPDATE_NEWS = "/WEB-INF/jsp/update_news.jsp";
    private static final String SESSION_LAST_URL = "lastUrl";
    private static final String SESSION_LAST_COMMAND = "GO_TO_USER_PAGE";
    private static final String GO_TO_AUTHORIZATION_PAGE = "Controller?command=GO_TO_AUTHORIZATION_PAGE";
    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    private static final String SESSION_USER_ROLE = "userRole";
    private static final String SESSION_NEWS_FOR_UPDATE = "newsForUpdate";

    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";
    private static final String NEWS_ID = "newsId";

    ServiceProvider serviceProvider = ServiceProvider.getInstance();
    NewsService newsService = serviceProvider.getNewsService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.setAttribute(SESSION_LAST_URL, SESSION_LAST_COMMAND);
        String userRole = (String) session.getAttribute(SESSION_USER_ROLE);
        if (Objects.equals(userRole, ADMIN_ROLE)) {
            int newsId;
            newsId = Integer.parseInt(request.getParameter(NEWS_ID));
            System.out.println(newsId);
            try {
                News newsForUpd = newsService.findNewsById(newsId);
                if (newsForUpd == null) {
                    response.sendRedirect(PATH_AFTER_EXCEPTION);
                    return;
                }
                session.setAttribute(SESSION_NEWS_FOR_UPDATE, newsForUpd);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(GO_TO_UPDATE_NEWS);
                requestDispatcher.forward(request, response);
            } catch (ServiceException e) {
                log.error(e);
                response.sendRedirect(PATH_AFTER_EXCEPTION);
            }
        } else response.sendRedirect(GO_TO_AUTHORIZATION_PAGE);
    }
}
