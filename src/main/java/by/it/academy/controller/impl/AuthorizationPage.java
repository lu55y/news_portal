package by.it.academy.controller.impl;

import by.it.academy.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthorizationPage implements Command {
    public static final String AUTHORIZATION_PAGE = "/WEB-INF/jsp/authorization_page.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(AUTHORIZATION_PAGE);
        requestDispatcher.forward(request, response);
    }
}
