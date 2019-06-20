package wcci.reviewssite;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

	@Resource
	ReviewRepository reviews;
	
	@Resource
	ReviewCrudRepo crudRepo;
	

	@RequestMapping("")
	public String renderReviews() {
		return "redirect:/reviews/all";
	}

	@RequestMapping("all")
	public String renderReviewsAll(Model model) {
		model.addAttribute("reviewsattribute", crudRepo.findAll());
		return "reviews-all";
	}

	@RequestMapping("{id}")
	public String renderReviewsSingle(@PathVariable("id") Long id, Model model) {
		model.addAttribute("single-review", crudRepo.findById(id));
		return "single-review";
	}

	@RequestMapping("new")
	public String renderReviewsNew() {
		return "write-review";
	}
	
	@PostMapping("add")
	
	public String addReview(String title, String imgurl, String category, String content) {
		Review reviewToAdd = new Review(title, imgurl, category, content);
		
			crudRepo.save(reviewToAdd);
		return "redirect:/reviews/all";
	}
	

}
