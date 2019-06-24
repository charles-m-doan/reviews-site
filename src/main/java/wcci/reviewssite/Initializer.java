package wcci.reviewssite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.reviewssite.model.Category;
import wcci.reviewssite.model.Review;
import wcci.reviewssite.repos.CategoryCrudRepo;
import wcci.reviewssite.repos.ReviewCrudRepo;


@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private ReviewCrudRepo reviewRepo;
	
	@Autowired
	private CategoryCrudRepo categoryRepo;

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
		

	}

}
