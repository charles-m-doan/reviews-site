package wcci.reviewssite;

import java.util.HashMap;
import java.util.Map;

public class ReviewRepository {
	Map<Long, Review> reviews = new HashMap<>();
	
	
	
	public void addReview(Review review) {
		reviews.put(review.getReviewID(), review);
	}
	
	public Review getReviewFromMap(Long id) {
		return reviews.get(id);
	}

	public int getNumReviews() {
		return reviews.size();
	}

}
