package by.it.academy.controller.impl.main_command;

import by.it.academy.controller.Command;
import by.it.academy.service.NewsService;
import by.it.academy.service.ServiceProvider;
import by.it.academy.service.exeption.ServiceException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class GoToMainPage implements Command {
    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    private static final Logger log= LogManager.getLogger(GoToMainPage.class);

    ServiceProvider serviceProvider = ServiceProvider.getInstance();
    NewsService newsService = serviceProvider.getNewsService();

    private static final String MAIN_PAGE = "/WEB-INF/jsp/main_page.jsp";
    private static final String LAST_NEWS ="lastNews";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute(LAST_NEWS,newsService.getLastNews());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(MAIN_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error("Database error while loading news",e);
            response.sendRedirect(PATH_AFTER_EXCEPTION);
        }
    }
}
