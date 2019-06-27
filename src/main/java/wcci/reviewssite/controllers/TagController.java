package wcci.reviewssite.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.reviewssite.model.Tag;
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
	public String renderSingleTag(@PathVariable("id") Long id, Model model) throws Exception {
		Optional<Tag> tagResult = tagRepo.findById(id);
		if (tagResult.isPresent()) {
			Tag tag = tagResult.get();
			model.addAttribute("tagModel", tag);
			model.addAttribute("reviewsModel", tag.getReviews());
			return "singleTagView";
		}
		throw new Exception();
	}
	

}
