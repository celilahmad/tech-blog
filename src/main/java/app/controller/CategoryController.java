package app.controller;

import app.entity.Category;
import app.entity.Post;
import app.service.CategoryService;
import app.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {

    private final PostService postService;
    private final CategoryService categoryService;

    public CategoryController(PostService postService, CategoryService categoryService) {
        this.postService = postService;
        this.categoryService = categoryService;
    }

    @GetMapping("/robotics")
    public String robotics(Model model){
         List<Post> all = postService.postCategory("robotics");
         List<Category> categories = categoryService.allCategory();
         model.addAttribute("categoryPost", all);
         model.addAttribute("categories", categories);
         return "tech-category";
    }

    @GetMapping("/network")
    public String network(Model model){
        List<Post> all = postService.postCategory("network");
        List<Category> categories = categoryService.allCategory();
        model.addAttribute("categoryPost", all);
        model.addAttribute("categories", categories);
        return "tech-category";
    }

    @GetMapping("/space")
    public String space(Model model){
        List<Post> all = postService.postCategory("space");
        List<Category> categories = categoryService.allCategory();
        model.addAttribute("categoryPost", all);
        model.addAttribute("categories", categories);
        return "tech-category";
    }

    @GetMapping("/ai")
    public String ai(Model model){
        List<Post> all = postService.postCategory("ai");
        List<Category> categories = categoryService.allCategory();
        model.addAttribute("categoryPost", all);
        model.addAttribute("categories", categories);
        return "tech-category";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        List<Category> categories = categoryService.allCategory();
        model.addAttribute("categories", categories);
        return "tech-contact";
    }
}
