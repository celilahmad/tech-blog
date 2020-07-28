package app.controller;

import app.entity.Category;
import app.entity.Post;
import app.service.CategoryService;
import app.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final PostService postService;
    private final CategoryService categoryService;

    public MainController(PostService postService, CategoryService categoryService) {
        this.postService = postService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String home(Model model) {
        List<Post> all = postService.allPosts();
        List<Category> categories = categoryService.allCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("posts", all);
        return "tech-index";

    }

}
