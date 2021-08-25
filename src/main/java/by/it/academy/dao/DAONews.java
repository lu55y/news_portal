package by.it.academy.dao;

import by.it.academy.bean.News;

import java.util.List;

public interface DAONews extends Dao<Integer,News>{
    List<News> findNewsByTitle(String title);
}
