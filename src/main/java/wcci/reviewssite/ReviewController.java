package wcci.reviewssite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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

}
