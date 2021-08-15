package by.it.academy.beans;

import java.util.Objects;

public class News extends Entity {

	private int id;
	private String title;
	private String briefDescription;

	public News(int id, String title, String briefDescription) {
		this.id = id;
		this.title = title;
		this.briefDescription = briefDescription;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		News news = (News) o;
		return id == news.id && Objects.equals(title, news.title) && Objects.equals(briefDescription, news.briefDescription);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, briefDescription);
	}

	@Override
	public String toString() {
		return "News{" +
				"id=" + id +
				", title='" + title + '\'' +
				", briefDescription='" + briefDescription + '\'' +
				'}';
	}
}
