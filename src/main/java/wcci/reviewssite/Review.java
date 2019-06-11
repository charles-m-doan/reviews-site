package wcci.reviewssite;

import java.util.UUID;

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

	public String getReviewTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReviewCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReviewContent() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReviewUrl() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
