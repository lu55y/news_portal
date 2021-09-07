package by.it.academy.controller.impl;

import by.it.academy.bean.User;
import by.it.academy.controller.Command;
import by.it.academy.service.NewsService;
import by.it.academy.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AddNews implements Command {
    private static final ServiceProvider SERVICE_PROVIDER =ServiceProvider.getInstance();
    private static final NewsService NEWS_SERVICE = SERVICE_PROVIDER.getNewsService();
    private static final String USER="user";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session==null)
            response.sendRedirect("Controller?command=go_to_authorization_page&message=Session lost, please try later.");
            return;
        User user = session.getAttribute(USER);

    }
}
