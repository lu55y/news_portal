package by.it.academy.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class FavoriteNews implements Serializable {

    @Serial
    private static final long serialVersionUID = 1680149724683541712L;

    private int id;
    private int user_id;
    private int news_id;

    public FavoriteNews(int id, int user_id, int news_id) {
        this.id = id;
        this.user_id = user_id;
        this.news_id = news_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteNews that = (FavoriteNews) o;
        return id == that.id && user_id == that.user_id && news_id == that.news_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, news_id);
    }

    @Override
    public String toString() {
        return "FavoriteNews{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", news_id=" + news_id +
                '}';
    }
}
