package wcci.reviewssite.controllers;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import wcci.reviewssite.repos.CategoryCrudRepo;
import wcci.reviewssite.repos.ReviewCrudRepo;

public class ReviewControllerTest {
	
	@InjectMocks
	private ReviewController underTest;
	
	@Mock
	private ReviewCrudRepo reviewRepo;
	
	@Mock
	private CategoryCrudRepo categoryRepo;

}
