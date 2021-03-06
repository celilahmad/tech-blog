package app.repo;

import app.entity.VideoPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VideoRepo extends JpaRepository<VideoPost, Integer> {

}
