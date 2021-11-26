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

public class GoToReadSelectedNews implements Command {
    private static final Logger log= LogManager.getLogger(GoToReadSelectedNews.class);
    ServiceProvider serviceProvider = ServiceProvider.getInstance();
    NewsService newsService = serviceProvider.getNewsService();

    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    private static final String NEWS_ID = "newsId";
    public static final String SESSION_LAST_URL = "lastUrl";
    public static final String SESSION_LAST_COMMAND = "Controller?command=GO_TO_NEWS_FROM_ID";
    private static final String READ_NEWS_PAGE = "/WEB-INF/jsp/read_news_page.jsp";
    private static final String SELECTED_NEWS ="selectedNews";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.setAttribute(SESSION_LAST_URL, SESSION_LAST_COMMAND);

        try {
            int newsId = Integer.parseInt(request.getParameter(NEWS_ID));
            News selectNews = newsService.findNewsById(newsId);
            request.setAttribute(SELECTED_NEWS,selectNews);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(READ_NEWS_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error("Database error while loading news",e);
            response.sendRedirect(PATH_AFTER_EXCEPTION);
        }
    }
}
