package by.it.academy.controller.impl.main_command;

import by.it.academy.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class GoToAboutPage implements Command {

    private static final String ABOUT_PAGE = "/WEB-INF/jsp/about_page.jsp";
    public static final String SESSION_LAST_URL = "lastUrl";
    public static final String SESSION_LAST_COMMAND = "Controller?command=GO_TO_ADMIN_PAGE";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.setAttribute(SESSION_LAST_URL, SESSION_LAST_COMMAND);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(ABOUT_PAGE);
        requestDispatcher.forward(request, response);
    }
}
