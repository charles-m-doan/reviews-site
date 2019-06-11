package wcci.reviewssite;

public class Review {
	Long reviewID;
	String title;
	String imgURL;
	String reviewCategory;
	String reviewContent;
	static long counter = 0;
	
	

	public Review(String title, String imgURL, String reviewCategory, String reviewContent) {
		super();
		this.reviewID = getNewId();
		this.title = title;
		this.imgURL = imgURL;
		this.reviewCategory = reviewCategory;
		this.reviewContent = reviewContent;
	}

	private Long getNewId() {
		counter++;
		return counter;
	}

	public Long getReviewID() {
		return this.reviewID;
	}

	public String getTitle() {
		return title;
	}

	public String getImgURL() {
		return imgURL;
	}

	public String getReviewCategory() {
		return reviewCategory;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public static long getCounter() {
		return counter;
	}

	
	
	
}
