package wcci.reviewssite;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ReviewRepositoryTest {
	Review underTest1 = new Review(1l, null, null, "bland", null);
	Review underTest2 = new Review(2l, null, null, null, null);
	Review underTest3 = new Review(3l, null, null, null, null);

	@Test
	public void canGetReviewObjectFromMap() {
		ReviewRepository repTest = new ReviewRepository();
		repTest.addReview(underTest1);
		assertEquals(underTest1, repTest.getReviewFromMap(underTest1.getId()));
	}

	@Test
	public void canGetNumberOfReviews() {
		ReviewRepository repTest = new ReviewRepository();
		repTest.addReview(underTest1);
		repTest.addReview(underTest2);
		repTest.addReview(underTest3);
		assertEquals(5, repTest.getNumReviews());
	}

	@Test
	public void canGetBlandReviews() {
		ReviewRepository repTest = new ReviewRepository();
		repTest.addReview(underTest1);
		ArrayList<Review> matchingReviews = repTest.getReviewsByCategory("bland");
		assertEquals(5, matchingReviews.size());
	}

}
