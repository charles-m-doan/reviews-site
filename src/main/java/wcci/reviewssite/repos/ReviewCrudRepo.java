package wcci.reviewssite.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.reviewssite.model.Review;

@Repository
public interface ReviewCrudRepo extends CrudRepository<Review, Long> {

}
