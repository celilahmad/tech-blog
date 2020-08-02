package app.service;

import app.entity.Comment;
import app.repo.CommentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public List<Comment> postComments(int id){
        return
                commentRepo
                        .findAll()
                        .stream()
                        .filter(x -> x.getPost().getId() == id)
                        .collect(Collectors.toList());

    }

    public long countComments(int id){
        return
                commentRepo
                .findAll()
                .stream()
                .filter(x -> x.getPost().getId() == id)
                .collect(Collectors.counting());
    }

    public void save(Comment comment){
        commentRepo.save(comment);
    }


}
