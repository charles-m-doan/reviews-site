package wcci.reviewssite.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.reviewssite.model.Comment;

@Repository
public interface CommentCrudRepo extends CrudRepository<Comment, Long>{

}
