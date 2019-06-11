package wcci.reviewssite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReviewTest {

	@Test
	public void reviewClassShouldExsist() {
		Review underTest = new Review(1, null, null, null, null);
	}
	
	
	@Test
	public void reviewsShouldHaveAttributes() {
		Review underTest = new Review(1, null, null, null, null);
		String reviewCheck1 = underTest.getImgURL();
		String reviewCheck2 = underTest.getTitle();
		Long reviewCheck3 = underTest.getId();
		String reviewCheck4 = underTest.getCategory();
		String reviewCheck5 = underTest.getContent();
		assertEquals(null, reviewCheck2);
		assertEquals(null, reviewCheck4);
		assertEquals(null, reviewCheck5);
		
	}
}
