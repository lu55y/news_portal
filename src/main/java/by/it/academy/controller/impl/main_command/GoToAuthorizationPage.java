package by.it.academy.controller.impl.main_command;

import by.it.academy.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GoToAuthorizationPage implements Command {
    public static final String AUTHORIZATION_PAGE = "/WEB-INF/jsp/authorization_page.jsp";
    public static final String SESSION_LAST_URL = "lastUrl";
    public static final String SESSION_LAST_COMMAND = "GO_TO_AUTHORIZATION_PAGE";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(false).setAttribute(SESSION_LAST_URL, SESSION_LAST_COMMAND);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(AUTHORIZATION_PAGE);
        requestDispatcher.forward(request, response);
    }
}
