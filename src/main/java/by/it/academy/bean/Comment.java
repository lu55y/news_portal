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
    private int news_id;
    private int user_id;

    public Comment(int id, String commentContent, String dateOfPublication, int news_id, int user_id) {
        this.id = id;
        this.commentContent = commentContent;
        this.dateOfPublication = dateOfPublication;
        this.news_id = news_id;
        this.user_id = user_id;
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

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && news_id == comment.news_id && user_id == comment.user_id && Objects.equals(commentContent, comment.commentContent) && Objects.equals(dateOfPublication, comment.dateOfPublication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentContent, dateOfPublication, news_id, user_id);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentContent='" + commentContent + '\'' +
                ", dateOfPublication='" + dateOfPublication + '\'' +
                ", news_id=" + news_id +
                ", user_id=" + user_id +
                '}';
    }
}
