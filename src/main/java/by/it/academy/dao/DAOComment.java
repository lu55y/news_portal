package by.it.academy.dao;

import by.it.academy.bean.Comment;
import by.it.academy.dao.exeption.DAOException;

import java.util.List;

public interface DAOComment {
    boolean create(Comment comment) throws DAOException;

    boolean delete(int commentId) throws DAOException;

    List<Comment> read(int newsId) throws DAOException;
}
