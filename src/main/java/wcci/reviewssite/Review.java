package wcci.reviewssite;

import java.util.UUID;

public class Review {
	UUID reviewID;
	String title;
	String imgURL;
	String reviewCategory;
	String reviewContent;
	
	

	public Review(String title, String imgURL, String reviewCategory, String reviewContent) {
		super();
		this.reviewID = UUID.randomUUID();
		this.title = title;
		this.imgURL = imgURL;
		this.reviewCategory = reviewCategory;
		this.reviewContent = reviewContent;
	}

	public String getReviewID() {
		// TODO Auto-generated method stub
		return null;
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
