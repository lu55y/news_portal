package by.it.academy.controller.impl.main_command;

import by.it.academy.controller.Command;
import by.it.academy.service.exeption.ServiceException;
import by.it.academy.service.NewsService;
import by.it.academy.service.ServiceProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class MainPage implements Command {

    ServiceProvider serviceProvider = ServiceProvider.getInstance();
    NewsService newsService = serviceProvider.getNewsService();

    private static final String MAIN_PAGE = "/WEB-INF/jsp/main_page.jsp";
    private static final String LASTNEWS="lastNews";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession(true);

        try {
            request.setAttribute(LASTNEWS,newsService.getLastNews());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(MAIN_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            //log
        }

    }
}
