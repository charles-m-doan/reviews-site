package wcci.reviewssite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Category category;

	String title;
	String imgurl;
	String content;

	public Review(String title, String imgurl, String content, Category category) {
		super();
		this.title = title;
		this.imgurl = imgurl;
		this.content = content;
		this.category = category;
		
	}

	public Long getId() {
		return id;
	}

	protected Review() {
	}

	public Category getCategory() {
		return category;
	}
	public String getTitle() {
		return title;
	}

	public String getImgurl() {
		return imgurl;
	}

	public String getContent() {
		return content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
