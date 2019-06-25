package wcci.reviewssite.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

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

	@Test
	public void reviewShouldHaveTag() throws Exception {
		Tag tag = new Tag("#something");
		System.out.println(tag.getName());
		Review review = new Review("Stone", null, null, null);
		System.out.println(review.getTitle());
		review.addTag(tag);
		assertTrue(review.getTags().contains(tag));
	}

}
