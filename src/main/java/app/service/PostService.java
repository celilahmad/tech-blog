package app.service;

import app.entity.Post;
import app.repo.PostRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostService {

    private final PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> allPosts(){
        return
                postRepo.findAll().stream()
                .collect(Collectors.toList());
    }


    public Post getPost(int id){
        return postRepo.findById(id).get();
    }

    public List<Post> postCategory(String category){
        return
                postRepo.findAll().stream()
                        .filter(x -> x.getCategory().equals(category))
                        .collect(Collectors.toList());
    }

    public List<Post> searchedPosts(String title){
        return
            postRepo.findAll().stream()
                    .filter(x -> x.getTitle().toLowerCase().contains(title.toLowerCase()))
                    .collect(Collectors.toList());
    }

    public List<Post> limitPost() {
        return
               postRepo.findAll().stream()
                    .limit(5)
                    .collect(Collectors.toList());
    }

    public Page<Post> listAll(int pageNumber){
        return postRepo.findAll(PageRequest.of(pageNumber - 1, 3));
    }

    public Page<Post> listByCategory(String category, int pageNumber){

        return
                postRepo.findAllByCategory(category, PageRequest.of(pageNumber -1, 2));

    }
}
