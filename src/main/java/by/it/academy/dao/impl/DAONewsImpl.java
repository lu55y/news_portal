package by.it.academy.dao.impl;

import by.it.academy.bean.News;
import by.it.academy.dao.DAONews;
import by.it.academy.dao.config.ConnectionPool;
import by.it.academy.dao.exeption.ConnectionPoolException;
import by.it.academy.dao.exeption.DAOException;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class DAONewsImpl implements DAONews {
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private static final ReentrantLock LOCKER=new ReentrantLock();
    private static final String SHOW_ALL_NEWS_DEFAULT= "SELECT * FROM news_portal.news WHERE news_status='PUBLISHED'";
    private static final String SHOW_ALL_NEWS = "SELECT * FROM news_portal.news";
    private static final String SHOW_NEWS_BY_TITLE = "SELECT * FROM news_portal.news WHERE news.title=?";
    private static final String FIND_NEWS_BY_ID = "SELECT * FROM news_portal.news WHERE news.id=?";
    private static final String UPDATE_NEWS = "UPDATE news_portal.news SET news.title=?, news.brief_description=?, news.content=? WHERE news.id=?";
    private static final String DELETE_NEWS_BY_ID = "DELETE FROM news_portal.news WHERE news.id=?";
    private static final String OFFER_NEWS = "INSERT INTO news_portal.news (title, brief_description, content, date_of_publication, news_status) VALUES (?,?,?,?,?)";
    private static final String PUBLISH_NEWS = "UPDATE news_portal.news SET news.news_status=? WHERE news.id=?";
    private static final String GET_LATEST_PUBLISHED_NEWS= "SELECT * FROM news_portal.news WHERE news_status = 'PUBLISHED' ORDER BY date_of_publication DESC LIMIT 5 ";

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final String ID="id";
    private final String TITLE="title";
    private final String BRIEF_DESCRIPTION="brief_description";
    private final String CONTENT="content";
    private final String DATE_OF_PUBLICATION="date_of_publication";
    private final String NEWS_STATUS="news_status";

    @Override
    public List<News> findAll() throws DAOException {
        List<News> listNews = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(SHOW_ALL_NEWS);
             ResultSet resultSet = prepStmt.executeQuery()) {
            while (resultSet.next()) {
                News news = new News(resultSet.getInt(ID),
                        resultSet.getString(TITLE),
                        resultSet.getString(BRIEF_DESCRIPTION),
                        resultSet.getString(CONTENT),
                        resultSet.getString(DATE_OF_PUBLICATION),
                        resultSet.getString(NEWS_STATUS));
                listNews.add(news);
            }
            return listNews;
        } catch (SQLException e) {
            //log
            throw new DAOException("News search error:", e);
        } catch (ConnectionPoolException e) {
            //log
            throw new DAOException("Connection error:", e);
        }
    }

    @Override
    public List<News> findAllPublished() throws DAOException {
        List<News> listNews = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(SHOW_ALL_NEWS_DEFAULT);
             ResultSet resultSet = prepStmt.executeQuery()) {
            while (resultSet.next()) {
                News news = new News(resultSet.getInt(ID),
                        resultSet.getString(TITLE),
                        resultSet.getString(BRIEF_DESCRIPTION),
                        resultSet.getString(CONTENT),
                        resultSet.getString(DATE_OF_PUBLICATION),
                        resultSet.getString(NEWS_STATUS));
                listNews.add(news);
            }
            return listNews;
        } catch (SQLException e) {
            //log
            throw new DAOException("News search error:", e);
        } catch (ConnectionPoolException e) {
            //log
            throw new DAOException("Connection error:", e);
        }
    }
    @Override
    public List<News> findLatestPublishedNews() throws DAOException {
        List<News> listNews = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(GET_LATEST_PUBLISHED_NEWS);
             ResultSet resultSet = prepStmt.executeQuery()) {
            while (resultSet.next()) {
                News news = new News(resultSet.getInt(ID),
                        resultSet.getString(TITLE),
                        resultSet.getString(BRIEF_DESCRIPTION),
                        resultSet.getString(CONTENT),
                        resultSet.getString(DATE_OF_PUBLICATION),
                        resultSet.getString(NEWS_STATUS));
                listNews.add(news);
            }
            return listNews;
        } catch (SQLException e) {
            throw new DAOException("News search error:", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection error:", e);
        }
    }

    @Override
    public List<News> findNewsByTitle(String title) throws DAOException {
        List<News> listNews = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(SHOW_NEWS_BY_TITLE)) {
            prepStmt.setString(1, title);
            resultSet = prepStmt.executeQuery();
            while (resultSet.next()) {
                News news = new News(resultSet.getInt(ID),
                        resultSet.getString(TITLE),
                        resultSet.getString(BRIEF_DESCRIPTION),
                        resultSet.getString(CONTENT),
                        resultSet.getString(DATE_OF_PUBLICATION),
                        resultSet.getString(NEWS_STATUS));
                listNews.add(news);
            }
        } catch (SQLException e) {
            //log
            throw new DAOException("News search by title error:", e);
        } catch (ConnectionPoolException e) {
            //log
            throw new DAOException("Connection error:", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    //log
                    throw new DAOException("Close error", e);
                }
            }
        }
        return listNews;
    }

    @Override
    public News findById(Integer id) throws DAOException {
        ResultSet resultSet = null;
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(FIND_NEWS_BY_ID)) {
            prepStmt.setInt(1, id);
            resultSet = prepStmt.executeQuery();
            if (resultSet.next()) {
                return  new News(resultSet.getInt(ID),
                        resultSet.getString(TITLE),
                        resultSet.getString(BRIEF_DESCRIPTION),
                        resultSet.getString(CONTENT),
                        resultSet.getString(DATE_OF_PUBLICATION),
                        resultSet.getString(NEWS_STATUS));
            }
        } catch (SQLException e) {
            //log
            throw new DAOException("News search by id error:", e);
        } catch (ConnectionPoolException e) {
            //log
            throw new DAOException("Connection error:", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    //log
                    throw new DAOException("Close error", e);
                }
            }
        }
        return null;
    }

    @Override
    public boolean updateNews(News news) throws DAOException {
        LOCKER.lock();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(UPDATE_NEWS)) {
            prepStmt.setString(1, news.getTitle());
            prepStmt.setString(2, news.getBriefDescription());
            prepStmt.setString(3, news.getContent());
            prepStmt.setInt(4, news.getId());
            int i = prepStmt.executeUpdate();
            if (i >= 1) return true;
        } catch (SQLException e) {
            //log
            throw new DAOException("News update error:", e);
        } catch (ConnectionPoolException e) {
            //log
            throw new DAOException("Connection error:", e);
        }finally {
            LOCKER.unlock();
        }
        return false;
    }

    @Override
    public boolean deleteByID(Integer id) throws DAOException {
        LOCKER.lock();
        try (Connection connection =CONNECTION_POOL.takeConnection() ;
             PreparedStatement prepStmt = connection.prepareStatement(DELETE_NEWS_BY_ID)){
            prepStmt.setInt(1, id);
            int i = prepStmt.executeUpdate();
            if (i >= 1) return true;
        } catch(SQLException e){
            throw new DAOException("Deleting news by id error:", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection error:", e);
        }finally {
            LOCKER.unlock();
        }
        return false;
    }

    @Override
    public boolean offerNews(News news) throws DAOException {
        LOCKER.lock();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(OFFER_NEWS)) {
            String status = "IN_PROCESSING";
            prepStmt.setString(1, news.getTitle());
            prepStmt.setString(2, news.getBriefDescription());
            prepStmt.setString(3, news.getContent());
            prepStmt.setString(4, getDate());
            prepStmt.setString(5, status);
            int i = prepStmt.executeUpdate();
            if (i >= 1) return true;
        } catch (SQLException e) {
            throw new DAOException("Error creating news:", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection error:", e);
        }finally {
            LOCKER.unlock();
        }
        return false;
    }

    @Override
    public boolean publishNews(News news) throws DAOException {
        LOCKER.lock();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(PUBLISH_NEWS)) {
            String PUBLISH = "PUBLISHED";
            prepStmt.setString(1, PUBLISH);
            prepStmt.setInt(2, news.getId());
            int i = prepStmt.executeUpdate();
            if (i >= 1) return true;
        } catch (SQLException e) {
            throw new DAOException("News update error:", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection error:", e);
        }finally {
            LOCKER.unlock();
        }
        return false;
    }

    private String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Timestamp date=new Timestamp(new Date().getTime());
        return dateFormat.format(date);
    }
}
