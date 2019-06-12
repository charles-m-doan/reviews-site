package wcci.reviewssite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

	ReviewRepository reviews = new ReviewRepository();

	@RequestMapping("/home/")
	public String renderHomePage(Model model) {
		model.addAttribute("home");
		
		return "home";
	}

	@RequestMapping("/review/")
	public String renderReviewPage(Model model) {
		Review review = new Review(1, "This is a review title", "url", "category stuff", "content stuff");

		model.addAttribute("review", review);
		return "review";
	}
	
	@RequestMapping("/")
	public String renderReviews(Model model) {
		reviews.populateRepository();

		model.addAttribute("reviews", reviews.getReviews());
		return "reviews";
	}
	
	@RequestMapping("/{id}")
	public String renderSpecificReviewPage(@PathVariable("id") long id, Model model) {
		reviews.populateRepository();
		model.addAttribute("review", reviews.getReviewFromMap(id));
		return "review";
	}
	

}
