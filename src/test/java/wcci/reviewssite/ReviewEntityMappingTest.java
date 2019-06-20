package wcci.reviewssite;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewEntityMappingTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ReviewCrudRepo reviewRepo;

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
}
