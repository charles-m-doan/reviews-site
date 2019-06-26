package wcci.reviewssite.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.reviewssite.model.Review;
import wcci.reviewssite.repos.ReviewCrudRepo;
import wcci.reviewssite.repos.TagCrudRepo;

@Controller
@RequestMapping("/tags")
public class TagController {

	@Resource
	TagCrudRepo tagRepo;
	
	@Resource
	ReviewCrudRepo reviewRepo;
	
	@RequestMapping("")
	public String renderAllTags(Model model) {
		model.addAttribute("tagsModel", tagRepo.findAll());
		return "allTagsView";
	}
	
	@RequestMapping("{id}")
	public String renderSingleTag(@PathVariable("id") Long id, Model model) {
		model.addAttribute("tagModel", tagRepo.findById(id).get());
		Collection<Review> reviews = tagRepo.findById(id).get().getReviews();
		
		//these should print the same thing
		System.out.println(reviews.size() + "LOOK HERE<-----");
		System.out.println(tagRepo.findById(id).get().getReviews().size() + "LOOK HERE<-----");
		
		model.addAttribute("reviewsModel", (tagRepo.findById(id).get()).getReviews());
		return "singleTagView";
	}

}
