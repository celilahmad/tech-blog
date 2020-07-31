package app.controller;

import app.entity.Category;
import app.entity.Post;
import app.entity.VideoPost;
import app.service.CategoryService;
import app.service.PostService;
import app.service.VideoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class CategoryController {

    private final PostService postService;
    private final CategoryService categoryService;
    private final VideoService videoService;

    public CategoryController(PostService postService, CategoryService categoryService, VideoService videoService) {
        this.postService = postService;
        this.categoryService = categoryService;
        this.videoService = videoService;
    }

    /*@GetMapping("/{category}")
    public String ai(Model model,
                     @PathVariable("category") String category){
        List<Post> all = postService.postCategory(category);
        List<Category> categories = categoryService.allCategory();
        model.addAttribute("categoryPost", all);
        model.addAttribute("categories", categories);
        return "tech-category";
    }*/

    @GetMapping("/contact")
    public String contact(Model model){
        List<Category> categories = categoryService.allCategory();
        model.addAttribute("categories", categories);
        return "tech-contact";
    }

    @RequestMapping("/{category}")
    public String category(Model model,
                           @PathVariable("category") String category) {

        return listByPage(model, category, 1);

    }

    @GetMapping("/{category}/page/{pageNumber}")
    public String listByPage(Model model,
                             @PathVariable("category") String category,
                             @PathVariable("pageNumber") int currentPage){
        Page<Post> page = postService.listByCategory(category.toLowerCase(), currentPage);
        long totalItem = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Integer> listTotalPages = IntStream.rangeClosed(1, page.getTotalPages()).boxed().collect(Collectors.toList());
        List<Post> all = page.getContent();
        List<VideoPost> front = videoService.frontPosts();
        List<Category> categories = categoryService.allCategory();

        model.addAttribute("path", category);
        model.addAttribute("front" , front);
        model.addAttribute("categories", categories);
        model.addAttribute("categoryPost", all);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItem", totalItem);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("listTotalPages", listTotalPages);

        return "tech-category";


    }
}
