package wcci.reviewssite;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ReviewRepositoryTest {
	
	@Test
	public void reviewClassShouldExsist() {
		Review underTest = new Review(null, null, null, null);
	}
	
	@Test
	public void canGetReviewObjectFromMap() {
		Review underTest = new Review(null, null, null, null);
		ReviewRepository repTest = new ReviewRepository();
		repTest.addReview(underTest);
		assertEquals(underTest, repTest.getReviewFromMap(underTest.getReviewID()));
	}
	@Test
	public void canGetNumberOfReviews() {
		Review underTest1 = new Review(null, null, null, null);
		Review underTest2 = new Review(null, null, null, null);
		Review underTest3 = new Review(null, null, null, null);
		ReviewRepository repTest = new ReviewRepository();
		repTest.addReview(underTest1);
		repTest.addReview(underTest2);
		repTest.addReview(underTest3);
		assertEquals(3, repTest.getNumReviews());
	}
	@Test
	public void canGetBlandReviews() {
			Review underTest1= new Review(null, null, "bland", null);
			ReviewRepository repTest = new ReviewRepository();
			repTest.addReview(underTest1);
			ArrayList<Review> matchingReviews= repTest.getReviewsByCategory("bland");
			assertEquals(1, matchingReviews.size());
			
	}
	
	
}
