package wcci.reviewssite.repos;

import org.springframework.data.repository.CrudRepository;

import wcci.reviewssite.model.Category;

public interface CategoryCrudRepo extends CrudRepository<Category, Long> {

}
