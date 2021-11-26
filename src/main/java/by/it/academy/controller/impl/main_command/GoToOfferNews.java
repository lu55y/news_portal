package by.it.academy.controller.impl.main_command;

import by.it.academy.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

public class GoToOfferNews implements Command {
    public static final String OFFER_NEWS_PAGE = "/WEB-INF/jsp/offer_news_page.jsp";
    public static final String SESSION_LAST_URL = "lastUrl";
    public static final String SESSION_LAST_COMMAND = "Controller?command=GO_TO_OFFER_NEWS_PAGE";
    private static final String SESSION_USER_ROLE = "userRole";
    private static final String GO_TO_AUTHORIZATION_PAGE = "Controller?command=GO_TO_AUTHORIZATION_PAGE";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.

        HttpSession session = request.getSession(false);
        session.setAttribute(SESSION_LAST_URL, SESSION_LAST_COMMAND);
        String userRole = (String) session.getAttribute(SESSION_USER_ROLE);
        if (Objects.equals(userRole, "ADMIN") || Objects.equals(userRole,"USER")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(OFFER_NEWS_PAGE);
            requestDispatcher.forward(request, response);
        } else response.sendRedirect(GO_TO_AUTHORIZATION_PAGE);
    }
}
