package by.it.academy.dao;

import by.it.academy.beans.News;
import by.it.academy.exeptions.DAOException;

import java.util.List;

public interface DAONews {

    void addNews(News news) throws DAOException;
    List<News> getListOfNewses() throws DAOException;
    News getNewsToId(int id) throws DAOException;
    News getNewsToTitle(String title) throws DAOException;
}
