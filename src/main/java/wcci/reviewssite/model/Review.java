package wcci.reviewssite.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Collection<Tag> tags = new ArrayList<Tag>();

	@OneToMany(mappedBy = "review")
	private Collection<Comment> comments = new ArrayList<Comment>();

	String title;
	String imgurl;

	@Lob
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

	public Collection<Tag> getTags() {
		return tags;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public int getCommentsSize() {
		return comments.size();
	}

	public void addTag(Tag tag) {
		if (!tags.contains(tag)) {
			this.tags.add(tag);
		}
	}

	public void addComment(Comment commentToAdd) {
		this.comments.add(commentToAdd);
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
