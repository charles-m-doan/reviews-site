package wcci.reviewssite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.reviewssite.model.Comment;
import wcci.reviewssite.model.Review;
import wcci.reviewssite.repos.CategoryCrudRepo;
import wcci.reviewssite.repos.CommentCrudRepo;
import wcci.reviewssite.repos.ReviewCrudRepo;
import wcci.reviewssite.repos.TagCrudRepo;

@Controller
@RequestMapping("/reviews")
public class ReviewController {


	@Resource
	ReviewCrudRepo reviewRepo;
	
	@Resource
	CategoryCrudRepo categoryRepo;
	
	@Resource
	CommentCrudRepo commentRepo;
	
	@Resource
	TagCrudRepo tagRepo;

	@RequestMapping("")
	public String renderReviewsAll(Model model) {
		model.addAttribute("reviewsModel", reviewRepo.findAll());
		return "reviewsView";
	}

	@RequestMapping("{id}")
	public String renderReviewsSingle(@PathVariable("id") Long id, Model model) {
		model.addAttribute("reviewModel", reviewRepo.findById(id).get());
		model.addAttribute("tagsModel", tagRepo.findAll());
		return "singleReviewView";
	}

	@RequestMapping("new")
	public String renderReviewsNew(Model model) {
		model.addAttribute("categoriesModel", categoryRepo.findAll());
		return "newReviewView";
	}
	
	@PostMapping("add")
	public String addReview(String title, String imgurl, String content, String category) {
		Review reviewToAdd = new Review(title, imgurl, content, categoryRepo.findByName(category));
		
			reviewRepo.save(reviewToAdd);
		return "redirect:/reviews/" + reviewToAdd.getId();
	}
	
	@PostMapping("add-comment")
	public String addComment(String content, Long id) {
		Comment commentToAdd = new Comment(reviewRepo.findById(id).get(), content);
		commentRepo.save(commentToAdd);
		return "redirect:/reviews/" + id;
	}
	

}
