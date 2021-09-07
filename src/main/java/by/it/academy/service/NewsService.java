package by.it.academy.service;

import by.it.academy.bean.News;
import by.it.academy.service.exeption.ServiceException;

import java.util.List;

public interface NewsService{

    List<News> findNewsByTitle(String title) throws ServiceException;

    List<News> findAllNews() throws ServiceException;

    News findNewsById(Integer id) throws ServiceException;

    boolean deleteNewsByID(Integer id) throws ServiceException;

    boolean updateNews(News news) throws ServiceException;

    List<News> findAllPublished() throws ServiceException;

    boolean offerNews(News news) throws ServiceException;

    boolean publishNews(News news)throws ServiceException;

    List<News> getLastNews() throws ServiceException;
}
