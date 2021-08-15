package by.it.academy.dao;

import by.it.academy.beans.News;

import java.util.List;

public interface DaoNews extends Dao<Long,News>{
    List<News> findNewsByTitle(String title);
}
