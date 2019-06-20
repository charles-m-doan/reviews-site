package wcci.reviewssite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	
	String title;
	String imgurl;
	String category;
	String content;

	public Review(String title, String imgurl, String category, String content) {
		super();
		this.title = title;
		this.imgurl = imgurl;
		this.category = category;
		this.content = content;
	}

	public Long getId() {
		return id;
	}
	
	protected Review() {
	}

	public String getTitle() {
		return title;
	}

	public String getImgurl() {
		return imgurl;
	}

	public String getCategory() {
		return category;
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
