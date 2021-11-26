package by.it.academy.service;

import by.it.academy.bean.Comment;
import by.it.academy.service.exeption.ServiceException;

import java.util.List;

public interface CommentService {
    boolean create(Comment comment)throws ServiceException;

    boolean delete(int commentId)throws ServiceException;

    List<Comment> read(int newsId)throws ServiceException;
}
