package by.it.academy.service;

import by.it.academy.beans.News;
import by.it.academy.exeptions.ServiceException;

import java.util.List;

public interface NewsService{

    boolean addNews(News news) throws ServiceException;
    List<News> getNews() throws ServiceException;
}
