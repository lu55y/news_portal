package by.it.academy.controller.impl.user_command;

import by.it.academy.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LogOutUser implements Command {
    public static final String MAIN_PAGE = "index.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        request.getRequestDispatcher(MAIN_PAGE).forward(request, response);
    }
}
