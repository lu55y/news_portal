package by.it.academy.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable{

	@Serial
	private static final long serialVersionUID = 364128800369547869L;

	private int id;
	private String title;
	private String briefDescription;
	private String content;
	private String dateOfPublication;
	private String newsStatus;

	public News(int id, String title, String briefDescription, String content, String dateOfPublication, String newsStatus) {
		this.id = id;
		this.title = title;
		this.briefDescription = briefDescription;
		this.content = content;
		this.dateOfPublication = dateOfPublication;
		this.newsStatus = newsStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(String dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getNewsStatus() {
		return newsStatus;
	}

	public void setNewsStatus(String newsStatus) {
		this.newsStatus = newsStatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		News news = (News) o;
		return id == news.id && Objects.equals(title, news.title) && Objects.equals(briefDescription, news.briefDescription) && Objects.equals(content, news.content) && Objects.equals(dateOfPublication, news.dateOfPublication) && Objects.equals(newsStatus, news.newsStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, briefDescription, content, dateOfPublication, newsStatus);
	}

	@Override
	public String toString() {
		return "News{" +
				"id=" + id +
				", title='" + title + '\'' +
				", briefDescription='" + briefDescription + '\'' +
				", content='" + content + '\'' +
				", dateOfPublication='" + dateOfPublication + '\'' +
				", newsStatus='" + newsStatus + '\'' +
				'}';
	}
}
