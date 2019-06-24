package wcci.reviewssite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.reviewssite.repos.CategoryCrudRepo;
import wcci.reviewssite.repos.ReviewCrudRepo;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Resource
	CategoryCrudRepo categoryRepo;

	@Resource
	ReviewCrudRepo reviewRepo;

	@RequestMapping("")
	public String renderCategoriessAll(Model model) {
		model.addAttribute("categoriesModel", categoryRepo.findAll());
//		model.addAttribute("reviewsModel", reviewRepo.findAll());
		return "categoriesView";
	}
	@RequestMapping("{id}")
	public String renderReviewsSingle(@PathVariable("id") Long id, Model model) {
		model.addAttribute("categoryModel", categoryRepo.findById(id).get());
		model.addAttribute("reviewsModel", (categoryRepo.findById(id).get()).getReviews());
		return "singleCategoryView";
	}

}
