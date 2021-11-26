package by.it.academy.service;

import by.it.academy.service.impl.CommentServiceImpl;
import by.it.academy.service.impl.NewsServiceImpl;
import by.it.academy.service.impl.UserServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider INSTANCE = new ServiceProvider();
    private UserService userService = new UserServiceImpl();
    private NewsService newsService = new NewsServiceImpl();
    private CommentService commentService = new CommentServiceImpl();

    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }

    public NewsService getNewsService() {
        return newsService;
    }

    public CommentService getCommentService() { return commentService; }
}
