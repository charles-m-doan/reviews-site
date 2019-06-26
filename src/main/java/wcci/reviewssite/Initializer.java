package wcci.reviewssite;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.reviewssite.model.Category;
import wcci.reviewssite.model.Review;
import wcci.reviewssite.model.Tag;
import wcci.reviewssite.model.Comment;
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

	@Override
	public void run(String... args) throws Exception {
		
		Category cat01 = new Category("Comedy");
		categoryRepo.save(cat01);
		
		Category cat02 = new Category("Crappy Super Hero Movies");
		categoryRepo.save(cat02);
		
		Category cat03 = new Category("Horror");
		categoryRepo.save(cat03);
		
		Review stone = new Review("Stone", "Not Null", "Not Null", cat01);
		reviewRepo.save(stone);
		
		Review roses = new Review("Roses", "Not Null", "Not Null", cat02);
		reviewRepo.save(roses);
		
		Review rolling = new Review("Rolling", "Not Null", "Not Null", cat02);
		reviewRepo.save(rolling);
		
		Review guns = new Review("Guns", "Not Null", "Not Null", cat02);
		reviewRepo.save(guns);
		
		Tag sticker = new Tag("Sticker");
		tagRepo.save(sticker);
		
		//trying to get tags to work
		
		sticker.addReview(roses);
		sticker.addReview(guns);
		sticker.addReview(rolling);
		
		roses.addTag(sticker);
		guns.addTag(sticker);
		rolling.addTag(sticker);
		
		reviewRepo.save(roses);
		reviewRepo.save(guns);
		reviewRepo.save(rolling);
		tagRepo.save(sticker);
		
		
		
		for(Review rev : sticker.getReviews()) {
			System.out.println(rev.getTitle() + " is the TITLE");
		}
		
		for(Tag tag : roses.getTags()) {
			System.out.println(tag.getName() + " is the TITLE");
		}
		
		System.out.println(sticker.getReviews().size() + "LOOK HERE<-----");
		
		Review retrievedRoses = reviewRepo.findById(roses.getId()).get();
		Collection<Tag> tags = retrievedRoses.getTags();
		System.out.println(tags.size() + "LOOK HERE<-----");
		
		Tag water = new Tag("Water");
		tagRepo.save(water);
		
		
		Comment sucks = new Comment(stone, "This review was terrible, why would you write this!?");
		commentRepo.save(sucks);
		
		Comment exactly = new Comment(stone, "Exactly what I thought, great review!");
		commentRepo.save(exactly);
	}

}
