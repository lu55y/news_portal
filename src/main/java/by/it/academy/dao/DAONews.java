package by.it.academy.dao;

import by.it.academy.beans.News;

import java.util.List;

public interface DAONews extends Dao<Integer,News>{
    List<News> findNewsByTitle(String title);
}
