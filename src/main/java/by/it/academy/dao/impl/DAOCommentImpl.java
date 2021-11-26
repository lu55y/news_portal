package by.it.academy.dao.impl;

import by.it.academy.bean.Comment;
import by.it.academy.dao.DAOComment;
import by.it.academy.dao.config.ConnectionPool;
import by.it.academy.dao.exeption.ConnectionPoolException;
import by.it.academy.dao.exeption.DAOException;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class DAOCommentImpl implements DAOComment {
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private static final String SHOW_ALL_NEWS_COMMENTS = "SELECT * FROM news_portal.comment WHERE news_id=?";
    private static final String ADD_NEW_COMMENTS = "INSERT INTO news_portal.comment (comment_content, date_of_publication, news_id, user_id, user_name) VALUES (?,?,?,?,?)";
    private static final String DELETE_NEWS_COMMENTS = "DELETE FROM news_portal.comment WHERE comment.id=?";
    private static final ReentrantLock LOCKER = new ReentrantLock();
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final String ID = "id";
    private final String CONTENT = "comment_content";
    private final String DATE = "date_of_publication";
    private final String NEWS_ID = "news_id";
    private final String USER_ID = "user_id";
    private final String USER_NAME = "user_name";

    @Override
    public boolean create(Comment comment) throws DAOException {
        LOCKER.lock();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(ADD_NEW_COMMENTS)) {
            String status = "IN_PROCESSING";
            System.out.println(comment);
            prepStmt.setString(1, comment.getCommentContent());
            prepStmt.setString(2, getDate());
            prepStmt.setInt(3, comment.getNewsId());
            prepStmt.setInt(4, comment.getUserId());
            prepStmt.setString(5, comment.getUserName());
            int i = prepStmt.executeUpdate();
            if (i >= 1) return true;
        } catch (SQLException e) {
            throw new DAOException("Error creating comment", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection error:", e);
        } finally {
            LOCKER.unlock();
        }
        return false;
    }

    @Override
    public boolean delete(int commentId) throws DAOException {
        LOCKER.lock();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(DELETE_NEWS_COMMENTS)) {
            prepStmt.setInt(1, commentId);
            int i = prepStmt.executeUpdate();
            if (i >= 1) return true;
        } catch (SQLException e) {
            throw new DAOException("Error deleting comment.", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection error:", e);
        }finally {
            LOCKER.unlock();
        }
        return false;
    }

    @Override
    public List<Comment> read(int newsId) throws DAOException {
        List<Comment> listComments = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement prepStmt = connection.prepareStatement(SHOW_ALL_NEWS_COMMENTS)) {
            prepStmt.setInt(1, newsId);
            ResultSet resultSet = prepStmt.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment(resultSet.getInt(ID),
                        resultSet.getString(CONTENT),
                        resultSet.getString(DATE),
                        resultSet.getInt(NEWS_ID),
                        resultSet.getInt(USER_ID),
                        resultSet.getString(USER_NAME));
                listComments.add(comment);
            }
            return listComments;
        } catch (SQLException e) {
            throw new DAOException("Comments search error:", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Connection error:", e);
        }
    }

    private String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Timestamp date = new Timestamp(new Date().getTime());
        return dateFormat.format(date);
    }
}
