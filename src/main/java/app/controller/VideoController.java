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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;
    private final CategoryService categoryService;
    private final PostService postService;

    public VideoController(VideoService videoService, CategoryService categoryService, PostService postService) {
        this.videoService = videoService;
        this.categoryService = categoryService;
        this.postService = postService;
    }


    /*@GetMapping
    public String allVideos(Model model){
        List<VideoPost> all = videoService.allVideoPosts();
        List<Category> categories = categoryService.allCategory();
        List<Post> posts = postService.limitPost();
        model.addAttribute("posts", posts);
        model.addAttribute("categories", categories);
        model.addAttribute("allVideos", all);
        return "tech-video";
    }*/

    @GetMapping
    public String home(Model model) {

        return listByPage(model, 1);

    }

    @GetMapping("/page/{pageNumber}")
    public String listByPage(Model model,
                             @PathVariable("pageNumber") int currentPage){
        Page<VideoPost> page = videoService.listAll(currentPage);
        List<Post> posts = postService.limitPost();
        long totalItem = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Integer> listTotalPages = IntStream.rangeClosed(1, page.getTotalPages()).boxed().collect(Collectors.toList());
        List<VideoPost> all = page.getContent();
        List<VideoPost> front = videoService.frontPosts();
        List<Category> categories = categoryService.allCategory();

        model.addAttribute("front" , front);
        model.addAttribute("categories", categories);
        model.addAttribute("posts", posts);
        model.addAttribute("allVideos", all);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItem", totalItem);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("listTotalPages", listTotalPages);

        return "tech-video";


    }
}
