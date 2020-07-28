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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final PostService postService;
    private final CategoryService categoryService;

    public SearchController(PostService postService, CategoryService categoryService) {
        this.postService = postService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String searchResult(@ModelAttribute("search") String search, Model model){
        List<Post> posts = postService.searchedPosts(search);
        List<Category> categories = categoryService.allCategory();
        model.addAttribute("posts", posts);
        model.addAttribute("categories", categories);
        return "search-result";
    }
}
