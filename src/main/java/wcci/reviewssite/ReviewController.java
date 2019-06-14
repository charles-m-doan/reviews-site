package wcci.reviewssite;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Resource
	ReviewRepository reviews;

//	@RequestMapping("/")
//	public String renderReviewPage(Model model) {
//		Review review = new Review(1, "This is a review title", "url", "category stuff", "content stuff");
//		model.addAttribute("review", review);
//		return "review";
//	}

	@RequestMapping("/all-reviews")
	public String renderReviews(Model model) {
		model.addAttribute("reviews", reviews.getReviews());
		return "reviews";
	}

	@RequestMapping("/{id}")
	public String renderSpecificReviewPage(@PathVariable("id") long id, Model model) {
		model.addAttribute("review", reviews.getReviewFromMap(id));
		return "review";
	}

}
