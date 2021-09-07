package by.it.academy.service.impl;

import by.it.academy.bean.News;
import by.it.academy.dao.DAONews;
import by.it.academy.dao.DAOProvider;
import by.it.academy.dao.exeption.DAOException;
import by.it.academy.service.exeption.ServiceException;
import by.it.academy.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    private static final DAOProvider daoProvider = DAOProvider.getINSTANCE();
    private static final DAONews daoNews = daoProvider.getDaoNews();

    @Override
    public List<News> findNewsByTitle(String title) throws ServiceException {
        try {
            return daoNews.findNewsByTitle(title);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public List<News> findAllNews() throws ServiceException {
        try {
            return daoNews.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public News findNewsById(Integer id) throws ServiceException {
        try {
            return daoNews.findById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteNewsByID(Integer id) throws ServiceException {
        try {
            return daoNews.deleteByID(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateNews(News news) throws ServiceException {
        try {
            return daoNews.updateNews(news);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<News> findAllPublished() throws ServiceException {
        try {
            return daoNews.findAllPublished();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean offerNews(News news) throws ServiceException {
        try {
            return daoNews.offerNews(news);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean publishNews(News news) throws ServiceException {
        try {
            return daoNews.publishNews(news);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
