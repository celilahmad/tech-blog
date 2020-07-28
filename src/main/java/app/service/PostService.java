package app.service;

import app.entity.Post;
import app.repo.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> allPosts(){
        return postRepo.findAll();
    }

    public List<Post> headPosts(){
        return postRepo.findAll().stream().limit(3).collect(Collectors.toList());
    }

    public Post getPost(int id){
        return postRepo.findById(id).get();
    }

    public List<Post> postCategory(String category){
        return
                postRepo
                        .findAll()
                        .stream()
                        .filter(x -> x.getCategory().equals(category))
                        .collect(Collectors.toList());
    }
}
