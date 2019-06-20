package wcci.reviewssite;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

	@Resource
	ReviewRepository reviews;

	@RequestMapping("")
	public String renderReviews() {
		return "redirect:/reviews/all";
	}

	@RequestMapping("all")
	public String renderReviewsAll(Model model) {
		model.addAttribute("reviews-all", reviews.getReviews());
		return "reviews-all";
	}

	@RequestMapping("{id}")
	public String renderReviewsSingle(@PathVariable("id") long id, Model model) {
		model.addAttribute("single-review", reviews.getReviewFromMap(id));
		return "single-review";
	}

	@RequestMapping("new")
	public String renderReviewsNew() {
		return "write-review";
	}

}
