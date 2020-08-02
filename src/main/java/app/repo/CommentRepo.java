package app.repo;

import app.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
