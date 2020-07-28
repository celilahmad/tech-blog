package app.controller;

import app.entity.Category;
import app.entity.Post;
import app.service.CategoryService;
import app.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class PostDetailController {

    private final PostService postService;
    private final CategoryService categoryService;

    public PostDetailController(PostService postService, CategoryService categoryService) {
        this.postService = postService;
        this.categoryService = categoryService;
    }

    @GetMapping("/detail/{id}")
    public String newsDetail(@ModelAttribute(name = "id") int id, Model model){
        List<Category> categories = categoryService.allCategory();
        Post post = postService.getPost(id);
        model.addAttribute("categories", categories);
        model.addAttribute("post", post);
        return "tech-single";

    }
}
