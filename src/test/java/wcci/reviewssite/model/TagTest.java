package wcci.reviewssite.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TagTest {

	String tagName01 = "#wcci";
	Tag testTag01 = new Tag(tagName01);

	@Test
	public void tagShouldHaveName() {
		assertEquals(tagName01, testTag01.getName());
	}

}
