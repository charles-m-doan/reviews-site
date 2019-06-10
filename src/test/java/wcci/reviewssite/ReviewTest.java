package wcci.reviewssite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReviewTest {

	@Test
	public void reviewClassShouldExsist() {
		Review underTest = new Review(null, null, null, null);
	}
	@Test
	public void reviewsShouldHaveAttributes() {
		Review underTest = new Review(null, null, null, null);
		String reviewCheck1 = underTest.getReviewUrl();
		String reviewCheck2 = underTest.getReviewTitle();
		String reviewCheck3 = underTest.getReviewID();
		String reviewCheck4 = underTest.getReviewCategory();
		String reviewCheck5 = underTest.getReviewContent();
		assertEquals(null, reviewCheck2);
		assertEquals(null, reviewCheck3);
		assertEquals(null, reviewCheck4);
		assertEquals(null, reviewCheck5);
		
	}
}
