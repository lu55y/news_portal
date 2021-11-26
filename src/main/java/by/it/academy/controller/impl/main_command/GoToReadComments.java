package by.it.academy.controller.impl.main_command;

import by.it.academy.bean.Comment;
import by.it.academy.controller.Command;
import by.it.academy.service.CommentService;
import by.it.academy.service.ServiceProvider;
import by.it.academy.service.exeption.ServiceException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class GoToReadComments implements Command {
    private static final Logger log= LogManager.getLogger(GoToReadComments.class);
    ServiceProvider serviceProvider = ServiceProvider.getInstance();
    CommentService commentService =serviceProvider.getCommentService();

    private static final String PATH_AFTER_EXCEPTION = "Controller?command=GO_TO_ERROR_PAGE";
    private static final String COMMENTS_PAGE = "/WEB-INF/jsp/comment_page.jsp";
    private static final String NEWS_ID = "newsId";
    private static final String COMMENTS_LIST ="commentList";
    private static final String COMMENT_COUNTER ="commentCounter";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int newsId = Integer.parseInt(request.getParameter(NEWS_ID));
            List<Comment> commentList = commentService.read(newsId);
            int size = commentList.size();
            request.setAttribute(COMMENTS_LIST,commentList);
            request.setAttribute(COMMENT_COUNTER,size);
            request.setAttribute(NEWS_ID,newsId);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(COMMENTS_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            log.error(e);
            response.sendRedirect(PATH_AFTER_EXCEPTION);
        }
    }
}
