package by.it.academy.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Comment implements Serializable {

    @Serial
    private static final long serialVersionUID = -2808889843359503140L;

    private int id;
    private String commentContent;
    private String dateOfPublication;
    private int newsId;
    private int userId;
    private String userName;

    public Comment(int id, String commentContent, String dateOfPublication, int newsId, int userId, String userName) {
        this.id = id;
        this.commentContent = commentContent;
        this.dateOfPublication = dateOfPublication;
        this.newsId = newsId;
        this.userId = userId;
        this.userName = userName;
    }

    public Comment(String commentContent, int newsId, int userId, String userName) {
        this.commentContent=commentContent;
        this.newsId = newsId;
        this.userId = userId;
        this.userName=userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && newsId == comment.newsId && userId == comment.userId && Objects.equals(commentContent, comment.commentContent) && Objects.equals(dateOfPublication, comment.dateOfPublication) && Objects.equals(userName, comment.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentContent, dateOfPublication, newsId, userId, userName);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentContent='" + commentContent + '\'' +
                ", dateOfPublication='" + dateOfPublication + '\'' +
                ", news_id=" + newsId +
                ", user_id=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}