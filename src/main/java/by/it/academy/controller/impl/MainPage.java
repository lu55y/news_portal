package by.it.academy.controller.impl;

import by.it.academy.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MainPage implements Command {

    private static final String MAIN_PAGE= "/WEB-INF/jsp/main_page.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(MAIN_PAGE);
        requestDispatcher.forward(request, response);
    }
}
