package app.controller;

import app.entity.Category;
import app.entity.Post;
import app.entity.VideoPost;
import app.service.CategoryService;
import app.service.PostService;
import app.service.VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final PostService postService;
    private final CategoryService categoryService;
    private final VideoService videoService;

    public MainController(PostService postService, CategoryService categoryService, VideoService videoService) {
        this.postService = postService;
        this.categoryService = categoryService;
        this.videoService = videoService;
    }

    @GetMapping
    public String home(Model model) {
        List<Post> all = postService.allPosts();
        List<Category> categories = categoryService.allCategory();
        List<VideoPost> front = videoService.frontPosts();
        model.addAttribute("front" , front);
        model.addAttribute("categories", categories);
        model.addAttribute("posts", all);
        return "tech-index";

    }

}
