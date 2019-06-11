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

}
