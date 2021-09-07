package by.it.academy.controller.impl.news_command;

import by.it.academy.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class NewsPage implements Command {

    private static final String NEWS_PAGE="/WEB-INF/jsp/news_page.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(NEWS_PAGE);
        requestDispatcher.forward(request, response);
    }
}
