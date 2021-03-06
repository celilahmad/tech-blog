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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller

public class MainController {

    private final PostService postService;
    private final CategoryService categoryService;
    private final VideoService videoService;

    public MainController(PostService postService, CategoryService categoryService, VideoService videoService) {
        this.postService = postService;
        this.categoryService = categoryService;
        this.videoService = videoService;
    }

    @RequestMapping("/")
    public String home(Model model) {

        return listByPage(model, 1);

    }

    @GetMapping("/page/{pageNumber}")
    public String listByPage(Model model,
                           @PathVariable("pageNumber") int currentPage){
        Page<Post> page = postService.listAll(currentPage);
        long totalItem = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Integer> listTotalPages = IntStream.rangeClosed(1, page.getTotalPages()).boxed().collect(Collectors.toList());
        List<Post> all = page.getContent();
        List<VideoPost> front = videoService.frontPosts();
        List<Category> categories = categoryService.allCategory();

        model.addAttribute("front" , front);
        model.addAttribute("categories", categories);
        model.addAttribute("posts", all);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItem", totalItem);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("listTotalPages", listTotalPages);

        return "tech-index";


    }
}
