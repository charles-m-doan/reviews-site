package wcci.reviewssite.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.reviewssite.model.Tag;

@Repository
public interface TagCrudRepo extends CrudRepository<Tag, Long> {

	Tag findByName(String name);

}
