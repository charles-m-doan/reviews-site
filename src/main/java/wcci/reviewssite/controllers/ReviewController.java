package wcci.reviewssite.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.reviewssite.model.Comment;
import wcci.reviewssite.model.Review;
import wcci.reviewssite.model.Tag;
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
		commentRepo.save(new Comment(reviewRepo.findById(id).get(), content));
		return "redirect:/reviews/" + id;
	}
  
	@PostMapping("add-tag")
	public String addTag(String name, Long id) throws Exception {
		Collection<Tag> tags = (Collection<Tag>) tagRepo.findAll();
		if (!tags.contains(tagRepo.findByName(name))) {
			reviewRepo.findById(id).get().addTag(tagRepo.save(new Tag(name)));
			reviewRepo.save(reviewRepo.findById(id).get());
		} else if (!reviewRepo.findById(id).get().getTags().contains(tagRepo.findByName(name))) {
			reviewRepo.findById(id).get().addTag(tagRepo.save(tagRepo.findByName(name)));
			reviewRepo.save(reviewRepo.findById(id).get());
		}
		return "redirect:/reviews/" + id;
	}



}
