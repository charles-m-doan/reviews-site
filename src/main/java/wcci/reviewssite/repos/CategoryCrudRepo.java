package wcci.reviewssite.repos;

import org.springframework.data.repository.CrudRepository;

import wcci.reviewssite.model.Review;

public interface CategoryCrudRepo extends CrudRepository<Review, Long> {

}
