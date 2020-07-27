package app.controller;

import app.entity.Post;
import app.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final PostService postService;

    public MainController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String home(Model model) {
        List<Post> all = postService.allPosts();
        List<Post> headPosts = postService.headPosts();
        model.addAttribute("heads", headPosts);
        model.addAttribute("posts", all);
        return "tech-index";

    }

    /*@GetMapping("detail")
    public String detail(Model model) {
        List<Post> all = postService.allPosts();
        model.addAttribute("posts", all);
        return "tech-single";

    }*/
}
