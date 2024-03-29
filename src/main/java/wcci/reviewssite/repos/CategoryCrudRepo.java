package wcci.reviewssite.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.reviewssite.model.Category;

@Repository
public interface CategoryCrudRepo extends CrudRepository<Category, Long> {

	Category findByName(String name);
}
