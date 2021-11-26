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

public class DeleteComment implements Command {
    private static final Logger log = LogManager.getLogger(DeleteComment.class);
    private static final String SESSION_ATTRIBUTE_USER_ROLE = "userRole";
    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    private static final String GO_TO_AUTHORIZATION = "Controller?command=GO_TO_AUTHORIZATION_PAGE";
    private static final String GO_TO_COMMENTS = "Controller?command=GO_TO_COMMENTS_PAGE";
    ServiceProvider provider = ServiceProvider.getInstance();
    CommentService commentService = provider.getCommentService();
    private String ADMIN="ADMIN";
    private String REQUEST_PARAM_COMMENT_ID="commentId";
    private String REQUEST_PARAM_NEWS_ID="newsId";
    private String PATH_PART="&newsId=";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        String role = (String) session.getAttribute(SESSION_ATTRIBUTE_USER_ROLE);
        if (!Objects.equals(role, ADMIN)){
            response.sendRedirect(GO_TO_AUTHORIZATION);
            return;
        }
        try {
            int commentIdParam = Integer.parseInt(request.getParameter(REQUEST_PARAM_COMMENT_ID));
            int newsIdParam = Integer.parseInt(request.getParameter(REQUEST_PARAM_NEWS_ID));
            System.out.println(commentIdParam);
            System.out.println(newsIdParam);
            if (commentService.delete(commentIdParam)){
                response.sendRedirect(GO_TO_COMMENTS+PATH_PART+newsIdParam);
            }else response.sendRedirect(PATH_AFTER_EXCEPTION);
        } catch (ServiceException e) {
            log.error(e);
            response.sendRedirect(PATH_AFTER_EXCEPTION);
        }
    }
}
