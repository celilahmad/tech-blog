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
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final PostService postService;
    private final CategoryService categoryService;
    private final VideoService videoService;

    public SearchController(PostService postService, CategoryService categoryService, VideoService videoService) {
        this.postService = postService;
        this.categoryService = categoryService;
        this.videoService = videoService;
    }

    @GetMapping
    public String searchResult(@ModelAttribute("search") String search, Model model){
        List<Post> posts = postService.searchedPosts(search);
        List<Category> categories = categoryService.allCategory();
        List<VideoPost> front = videoService.frontPosts();
        model.addAttribute("front", front);
        model.addAttribute("posts", posts);
        model.addAttribute("categories", categories);
        return "search-result";
    }

}
