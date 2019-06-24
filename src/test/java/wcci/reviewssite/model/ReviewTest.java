package wcci.reviewssite.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import wcci.reviewssite.model.Review;

public class ReviewTest {

	@Test
	public void reviewClassShouldExsist() {
		Review underTest = new Review(null, null, null, null);
	}
	
	
	@Test
	public void reviewsShouldHaveAttributes() {
		Review underTest = new Review(null, null, null, null);
		String reviewCheck1 = underTest.getImgurl();
		String reviewCheck2 = underTest.getTitle();
		Long reviewCheck3 = underTest.getId();
		String reviewCheck5 = underTest.getContent();
		assertEquals(null, reviewCheck2);
		assertEquals(null, reviewCheck3);
		assertEquals(null, reviewCheck5);
		
	}
}
