package wcci.reviewssite.controllers;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.reviewssite.model.Review;
import wcci.reviewssite.repos.ReviewCrudRepo;

@Controller
@RequestMapping("/reviews")
public class ReviewController {


	@Resource
	ReviewCrudRepo reviewRepo;

	@RequestMapping("")
	public String renderReviewsAll(Model model) {
		model.addAttribute("reviewsModel", reviewRepo.findAll());
		return "reviewsView";
	}

	@RequestMapping("{id}")
	public String renderReviewsSingle(@PathVariable("id") Long id, Model model) {
		model.addAttribute("reviewModel", reviewRepo.findById(id).get());
		return "singleReviewView";
	}

	@RequestMapping("new")
	public String renderReviewsNew() {
		return "newReviewView";
	}
	
	@PostMapping("add")
	public String addReview(String title, String imgurl, String category, String content) {
		Review reviewToAdd = new Review(title, imgurl, content, null);
		
			reviewRepo.save(reviewToAdd);
		return "redirect:/reviews";
	}
	

}
