package by.it.academy.dao.impl;

import by.it.academy.dao.config.DBCPDataSourceFactory;
import by.it.academy.beans.News;
import by.it.academy.dao.DaoNews;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAONewsImpl implements DaoNews {
    @Override
    public List<News> findAll() {
        List<News> listNews = new ArrayList<>();
        Connection connection = null;
        String selectSQL = "SELECT * FROM news_portal.news";
        PreparedStatement prepStmt = null;
        ResultSet resultSet=null;
        try {
            connection= DBCPDataSourceFactory.getInstance().getConnection();
            prepStmt=connection.prepareStatement(selectSQL);
            resultSet= prepStmt.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String briefDescription = resultSet.getString(3);
                News news=new News(id,title,briefDescription);
                listNews.add(news);
                System.out.println("Title:" + title);
                System.out.println("Brief Description:" + briefDescription);
            }
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        }finally {
            closeStatement(prepStmt);
            closeConnection(connection);
        }
        return listNews;
    }

    @Override
    public List<News> findNewsByTitle(String title) {
        return null;
    }

    @Override
    public News findEntityById(Long id) {
        return null;
    }

    @Override
    public boolean delete(News news) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(News news) {
        return false;
    }

    @Override
    public News update(News news) {
        return null;
    }
}
