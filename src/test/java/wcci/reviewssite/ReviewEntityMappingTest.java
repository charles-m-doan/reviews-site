package wcci.reviewssite;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import wcci.reviewssite.model.Category;
import wcci.reviewssite.model.Review;
import wcci.reviewssite.model.Tag;
import wcci.reviewssite.repos.CategoryCrudRepo;
import wcci.reviewssite.repos.ReviewCrudRepo;
import wcci.reviewssite.repos.TagCrudRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewEntityMappingTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ReviewCrudRepo reviewRepo;

	@Autowired
	private CategoryCrudRepo categoryRepo;

	@Autowired
	private TagCrudRepo tagRepo;

	@Test
	public void shouldSaveAndLoadAReview() {
		Review stone = new Review("Stone", null, null, null);
		entityManager.persist(stone);
		entityManager.flush();

		Review foundReview = reviewRepo.findById(stone.getId()).get();
		assertThat(foundReview.getTitle(), is("Stone"));
		// or use the AssertJ assertThat
		assertThat(foundReview.getTitle()).isEqualTo(stone.getTitle());
	}

	@Test
	public void shouldSaveAndLoadCategory() {
		Category cat = new Category("Sad");
		entityManager.persist(cat);
		entityManager.flush();
		Category foundCategory = categoryRepo.findById(cat.getId()).get();
		assertThat(foundCategory.getName(), is("Sad"));
		assertThat(foundCategory.getName()).isEqualTo(cat.getName());
	}

	@Test
	public void tagShouldHaveReview() throws Exception {
		Tag tag = new Tag("#something");
		Category category = new Category("horror");
		Review review = new Review("Stone", "", "", category);

		review.addTag(tag);

		tagRepo.save(tag);
		categoryRepo.save(category);
		reviewRepo.save(review);

		entityManager.flush();
		entityManager.clear();

		Review retrievedReview = reviewRepo.findById(review.getId()).get();
		assertEquals(1, retrievedReview.getTags().size());
		assertEquals(1, reviewRepo.findById(review.getId()).get().getTags().size());

		Tag retrievedTag = tagRepo.findById(tag.getId()).get();
//		assertEquals(1, retrievedTag.getReviews().size());
//		assertEquals(1, tagRepo.findById(tag.getId()).get().getReviews().size());
		
		
	}
	@Test
	public void reviewShouldHaveReview() {
	}
}