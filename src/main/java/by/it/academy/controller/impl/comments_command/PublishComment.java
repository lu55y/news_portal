package by.it.academy.controller.impl.comments_command;

import by.it.academy.bean.Comment;
import by.it.academy.bean.User;
import by.it.academy.controller.Command;
import by.it.academy.service.CommentService;
import by.it.academy.service.ServiceProvider;
import by.it.academy.service.UserService;
import by.it.academy.service.exeption.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Objects;

public class PublishComment implements Command {
    private static final Logger log = LogManager.getLogger(PublishComment.class);
    private static final String SESSION_ATTRIBUTE_USER_ROLE = "userRole";
    private static final String SESSION_ATTRIBUTE_USER_ID = "userId";
    private static final String PATH_AFTER_PUBLISH = "Controller?command=GO_TO_COMMENTS_PAGE";
    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    private static final String GO_TO_AUTHORIZATION = "Controller?command=GO_TO_AUTHORIZATION_PAGE";
    ServiceProvider provider = ServiceProvider.getInstance();
    UserService userService = provider.getUserService();
    CommentService commentService = provider.getCommentService();
    private String ADMIN = "ADMIN";
    private String USER = "USER";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String role = (String) session.getAttribute(SESSION_ATTRIBUTE_USER_ROLE);
        Integer userIdAtr = (Integer) session.getAttribute(SESSION_ATTRIBUTE_USER_ID);
        String commentContent = request.getParameter("commentContent");
        if (!Objects.equals(role, ADMIN)) {
            if (!Objects.equals(role, USER)) {
                response.sendRedirect(GO_TO_AUTHORIZATION);
                return;
            }
        }
        try {
            User userById = userService.findUserById(userIdAtr);
            if (userById == null) {
                response.sendRedirect(GO_TO_AUTHORIZATION);
                return;
            }
            System.out.println(userById);
            int newsId = Integer.parseInt(request.getParameter("newsId"));
            System.out.println(newsId);
            int userId = userById.getId();
            String userName = userById.getName();
            Comment comment=new Comment(commentContent,newsId, userId, userName);
            System.out.println(newsId);
            System.out.println(comment);
            if (commentService.create(comment)) {
                String s = response.encodeRedirectURL(PATH_AFTER_PUBLISH + "&newsId=" + newsId);
                response.sendRedirect(s);
            } else {
                System.out.println("create err");
                response.sendRedirect(PATH_AFTER_EXCEPTION);
            }
        } catch (ServiceException e) {
            log.error(e);
            response.sendRedirect(PATH_AFTER_EXCEPTION);
        }
    }
}
