package wcci.reviewssite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ReviewRepository {
	Map<Long, Review> reviews = new HashMap<>();

	public void addReview(Review review) {
		reviews.put(review.getId(), review);
	}

	public Review getReviewFromMap(Long id) {
		return reviews.get(id);
	}

	public int getNumReviews() {
		return reviews.size();
	}

	public Collection<Review> getReviews() {
		return reviews.values();
	}

	public ArrayList<Review> getReviewsByCategory(String string) {
		ArrayList<Review> matchingReviews = new ArrayList<>();
		for (Review rev : reviews.values()) {
			if (rev.getCategory().equals(string)) {
				matchingReviews.add(rev);
			}
		}
		return matchingReviews;
	}

	public void populateRepository() {
		if(reviews.isEmpty() ) {
			addReview(new Review(1L, "Scarface", null, "bland", null));
			addReview(new Review(2L, "Goodfellas", null, "bland", null));
			addReview(new Review(3L, "Raging Bull", null, "bland", null));
			addReview(new Review(4L, "Taxi Driver", null, "bland", null));
			addReview(new Review(5L, "Big Trouble in Little China", null, "bland", null));
			
			
		}
	}
}
