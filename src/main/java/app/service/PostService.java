package app.service;

import app.entity.Post;
import app.repo.PostRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public List<Post> searchedPosts(String title){
        return
                postRepo
                    .findAll()
                    .stream()
                    .filter(x -> x.getTitle().toLowerCase().contains(title.toLowerCase()))
                    .collect(Collectors.toList());
    }

    public List<Post> limitPost() {
        return
                postRepo
                    .findAll()
                    .stream()
                    .limit(5)
                    .collect(Collectors.toList());
    }

    public Page<Post> findById(@RequestParam("id") int id){
        return postRepo.findAllById(0, new PageRequest(0, 2));
    }
}
