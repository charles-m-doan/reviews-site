package wcci.reviewssite;

public class Review {
	
	Long id;
	String title;
	String imgurl;
	String category;
	String content;

	public Review(long id, String title, String imgurl, String category, String content) {
		super();
		this.id = id;
		this.title = title;
		this.imgurl = imgurl;
		this.category = category;
		this.content = content;
	}

	public Long getId() {
		return id;
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

	

}
