package by.it.academy.service.impl;

import by.it.academy.beans.News;
import by.it.academy.exeptions.ServiceException;
import by.it.academy.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    @Override
    public boolean addNews(News news) throws ServiceException {
        return false;
    }

    @Override
    public List<News> getNews() throws ServiceException {

        return null;
    }

}
