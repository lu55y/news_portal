package by.it.academy.dao.impl;

import by.it.academy.dao.config.DBCPDataSourceFactory;
import by.it.academy.beans.News;
import by.it.academy.dao.DAONews;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAONewsImpl implements DAONews {
    @Override
    public List<News> findAll() {
        List<News> listNews = new ArrayList<>();
        Connection connection = null;
        String SQLQuery = "SELECT * FROM news_portal.news";
        PreparedStatement prepStmt = null;
        ResultSet resultSet=null;
        try {
            connection= getInstance().getConnection();
            prepStmt=connection.prepareStatement(SQLQuery);
            resultSet= prepStmt.executeQuery();
            while (resultSet.next()){
                int newsId = resultSet.getInt(1);
                String newsTitle = resultSet.getString(2);
                String newsBriefDescription = resultSet.getString(3);
                News news=new News(newsId,newsTitle,newsBriefDescription);
                listNews.add(news);
//
                System.out.println("Title:" + newsTitle);
                System.out.println("Brief Description:" + newsBriefDescription);
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
        List<News> listNews = new ArrayList<>();
        Connection connection = null;
        String SQLQuery = "SELECT * FROM news_portal.news Where news.title=?";
        PreparedStatement prepStmt = null;
        ResultSet resultSet=null;
        try {
            connection= getInstance().getConnection();
            prepStmt=connection.prepareStatement(SQLQuery);
            prepStmt.setString(1,title);
            resultSet= prepStmt.executeQuery();
            while (resultSet.next()){
                int newsId = resultSet.getInt(1);
                String newsTitle = resultSet.getString(2);
                String newsBriefDescription = resultSet.getString(3);
                News news=new News(newsId,newsTitle,newsBriefDescription);
                listNews.add(news);
//
                System.out.println("Title:" + newsTitle);
                System.out.println("Brief Description:" + newsBriefDescription);
                return listNews;
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
    public News findById(Integer id) {
        Connection connection = null;
        String SQLQuery = "SELECT * FROM news_portal.news Where news.id=?";
        PreparedStatement prepStmt = null;
        ResultSet resultSet=null;
        try {
            connection= getInstance().getConnection();
            prepStmt=connection.prepareStatement(SQLQuery);
            prepStmt.setInt(1,id);
            resultSet= prepStmt.executeQuery();
            while (resultSet.next()){
                int newsId = resultSet.getInt(1);
                String newsTitle = resultSet.getString(2);
                String newsBriefDescription = resultSet.getString(3);
                News news=new News(newsId,newsTitle,newsBriefDescription);

        //
                System.out.println("Title:" + newsTitle);
                System.out.println("Brief Description:" + newsBriefDescription);
        //
                return news;
            }
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        }finally {
            closeStatement(prepStmt);
            closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean delete(News news) {
        Connection connection = null;
        String SQLQuery = "delete news FROM news_portal.news Where news.id=? AND news.title=? AND news.briefDescription=?";
        PreparedStatement prepStmt = null;
        try {
            connection= getInstance().getConnection();
            prepStmt=connection.prepareStatement(SQLQuery);
            prepStmt.setInt(1,news.getId());
            prepStmt.setString(2,news.getTitle());
            prepStmt.setString(3,news.getBriefDescription());
            int i = prepStmt.executeUpdate();
            if (i>=1){
                return true;
            }
            connection.rollback();
            return false;
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        }finally {
            closeStatement(prepStmt);
            closeConnection(connection);
        }
        return false;
    }


    @Override
    public boolean create(News news) {
        Connection connection = null;
        String SQLQuery = "insert into news_portal.news (ID, TITLE, BRIEFDESCRIPTION) values (?,?,?)";
        PreparedStatement prepStmt = null;
        try {
            connection= getInstance().getConnection();
            prepStmt=connection.prepareStatement(SQLQuery);
            prepStmt.setInt(1,news.getId());
            prepStmt.setString(2,news.getTitle());
            prepStmt.setString(3,news.getBriefDescription());
            int i = prepStmt.executeUpdate();
            if (i>=1){
                return true;
            }
            connection.rollback();
            return false;
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        }finally {
            closeStatement(prepStmt);
            closeConnection(connection);
        }
        return false;
    }

    @Override
    public News update(News news) {
        Connection connection = null;
        String SQLQuery = "update news_portal.news set news.title=? and news.briefDescription=? Where news.id=? AND news.title=? AND news.briefDescription=?";
        PreparedStatement prepStmt = null;
        try {
            connection= getInstance().getConnection();
            prepStmt=connection.prepareStatement(SQLQuery);
            prepStmt.setInt(1,news.getId());
            prepStmt.setString(2,news.getTitle());
            prepStmt.setString(3,news.getBriefDescription());
            int i = prepStmt.executeUpdate();
            if (i>=1){
                return news;
            }
            connection.rollback();
            return null;
        } catch (SQLException e) {
            //log
            e.printStackTrace();
        }finally {
            closeStatement(prepStmt);
            closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    private DBCPDataSourceFactory getInstance() {
        return DBCPDataSourceFactory.getInstance();
    }
}
