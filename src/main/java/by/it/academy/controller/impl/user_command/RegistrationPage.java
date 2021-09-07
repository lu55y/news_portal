package by.it.academy.controller.impl.user_command;

import by.it.academy.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegistrationPage implements Command {
    private static final String REGISTRATION_PAGE = "/WEB-INF/jsp/registration_page.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(REGISTRATION_PAGE);
        requestDispatcher.forward(request, response);
    }
}
