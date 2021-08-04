package by.it.academy.beans;

import java.util.Objects;

public class News {

	private String title;
	private String briefDescription;

	public News(String title, String briefDescription) {
		this.title = title;
		this.briefDescription = briefDescription;
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
		return Objects.equals(title, news.title) && Objects.equals(briefDescription, news.briefDescription);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, briefDescription);
	}

	@Override
	public String toString() {
		return "News{" +
				"title='" + title + '\'' +
				", briefDescription='" + briefDescription + '\'' +
				'}';
	}


	
}
