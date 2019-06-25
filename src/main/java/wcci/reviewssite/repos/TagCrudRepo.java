package wcci.reviewssite.repos;

import org.springframework.data.repository.CrudRepository;

import wcci.reviewssite.model.Tag;

public interface TagCrudRepo extends CrudRepository<Tag, Long> {

}
