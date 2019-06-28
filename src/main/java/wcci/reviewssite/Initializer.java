package wcci.reviewssite;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.reviewssite.model.Category;
import wcci.reviewssite.model.Comment;
import wcci.reviewssite.model.Review;
import wcci.reviewssite.model.Tag;
import wcci.reviewssite.repos.CategoryCrudRepo;
import wcci.reviewssite.repos.CommentCrudRepo;
import wcci.reviewssite.repos.ReviewCrudRepo;
import wcci.reviewssite.repos.TagCrudRepo;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private ReviewCrudRepo reviewRepo;

	@Autowired
	private CategoryCrudRepo categoryRepo;

	@Autowired
	private CommentCrudRepo commentRepo;

	@Autowired
	private TagCrudRepo tagRepo;

	private AutoPopulator populator = new AutoPopulator();

	@Override
	public void run(String... args) throws Exception
		{
		populator.saveDefaults(categoryRepo, tagRepo);
		ArrayList<Review> reviews = populator.createDefaultReviews();
		for (Review review : reviews)
			{
			reviewRepo.save(review);
			populator.addRandomTagsToReview(review, 1, 4);
			reviewRepo.save(review);
			}
		}
}
