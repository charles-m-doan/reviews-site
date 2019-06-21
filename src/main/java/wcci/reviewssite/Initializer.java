package wcci.reviewssite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.reviewssite.model.Review;
import wcci.reviewssite.repos.ReviewCrudRepo;


@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private ReviewCrudRepo reviewRepo;

	@Override
	public void run(String... args) throws Exception {

		Review stone = new Review("Stone", "Not Null", "Not Null");
		reviewRepo.save(stone);
		
		Review roses = new Review("Roses", "Not Null", "Not Null");
		reviewRepo.save(roses);

		

	}

}
