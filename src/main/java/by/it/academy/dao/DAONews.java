package by.it.academy.dao;

import by.it.academy.bean.News;
import by.it.academy.dao.exeption.DAOException;

import java.util.List;

public interface DAONews{
    List<News> findNewsByTitle(String title) throws DAOException;

    List<News> findAll() throws DAOException;

    News findById(Integer id) throws DAOException;

    boolean deleteByID(Integer id) throws DAOException;

    boolean updateNews(News news) throws DAOException;

    List<News> findAllPublished() throws DAOException;

    boolean offerNews(News news) throws DAOException;

    boolean publishNews(News news)throws DAOException;

//    boolean getNewsComments(News news) throws DAOException;
//
//    boolean addCommentToNews(News news) throws DAOException;
//
//    boolean deleteCommentFromNews(News news) throws DAOException;
//
//    List<News> findAllFavoriteNews() throws DAOException;
//
//    boolean addNewsToFavorite(User user) throws DAOException;
//
//    boolean deleteNewsFromFavorite(User user) throws DAOException;
}
