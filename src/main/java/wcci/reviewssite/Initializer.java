package wcci.reviewssite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private ReviewCrudRepo reviewRepo;

	@Override
	public void run(String... args) throws Exception {

		Review stone = new Review(0, "Stone", null, null, null);
		reviewRepo.save(stone);
		Review roses = new Review(1, "Roses", null, null, null);
		reviewRepo.save(roses);

		

	}

}
