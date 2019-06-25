package wcci.reviewssite.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TagTest {

	String tagName01 = "#wcci";
	Tag testTag01 = new Tag(tagName01);

	@Test
	public void tagShouldHaveName() {
		assertEquals(tagName01, testTag01.getName());
	}

	@Test
	public void reviewShouldHaveTag() throws Exception {
		Tag tag = new Tag("#something");
		Review review = new Review("Stone", null, null, null);
		tag.addReview(review);
		assertTrue(tag.getReviews().contains(review));
	}

}
