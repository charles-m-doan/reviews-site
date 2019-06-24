package wcci.reviewssite;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import wcci.reviewssite.controllers.ReviewController;
import wcci.reviewssite.model.Category;
import wcci.reviewssite.model.Review;
import wcci.reviewssite.repos.CategoryCrudRepo;
import wcci.reviewssite.repos.ReviewCrudRepo;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewMockMvcTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ReviewCrudRepo reviewRepo;
	
	@MockBean
	private CategoryCrudRepo categoryRepo;
	
	@Mock 
	private Review reviewOne;
	
	@Mock
	private Review reviewTwo;
	
	@Mock
	private Category categoryOne;
	
	@Mock
	private Category categoryTwo;
	
	@Test
	public void shouldRetoryStatusOfOk() throws Exception {
	Collection<Review> reviews = Arrays.asList(reviewOne, reviewTwo);
	when(reviewRepo.findAll()).thenReturn(reviews);
	mvc.perform(get("/reviews")).andExpect(view().name(is("reviewsView")));	
	}
	
	@Test
	public void addCategoryTest() throws Exception {
		Category categoryToAdd = new Category("good");
		
		mvc.perform(post("/reviews/add")).andExpect(status().is3xxRedirection());
		//will need to recode this after we make a category controller
		
		
	}
	
	
}
