package by.it.academy.service.impl;

import by.it.academy.bean.Comment;
import by.it.academy.dao.DAOComment;
import by.it.academy.dao.DAOProvider;
import by.it.academy.dao.exeption.DAOException;
import by.it.academy.service.CommentService;
import by.it.academy.service.exeption.ServiceException;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private static final DAOProvider daoProvider = DAOProvider.getINSTANCE();
    private static final DAOComment DAO_COMMENT = daoProvider.getDaoComment();

    @Override
    public boolean create(Comment comment) throws ServiceException {
        try {
            return DAO_COMMENT.create(comment);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(int commentId) throws ServiceException {
        try {
            return DAO_COMMENT.delete(commentId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Comment> read(int newsId) throws ServiceException {
        try {
            return DAO_COMMENT.read(newsId);
        } catch (DAOException e) {
           throw new ServiceException(e);
        }
    }
}