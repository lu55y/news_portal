package by.it.academy.dao.impl;

import by.it.academy.beans.News;
import by.it.academy.dao.DAONews;
import by.it.academy.exeptions.DAOException;

import java.util.List;

public class DAONewsImpl implements DAONews {


    @Override
    public void addNews(News news) throws DAOException {

    }

    @Override
    public List<News> getListOfNewses() throws DAOException {
        return null;
    }

    @Override
    public News getNewsToId(int id) throws DAOException {
        return null;
    }

    @Override
    public News getNewsToTitle(String title) throws DAOException {
        return null;
    }
}
