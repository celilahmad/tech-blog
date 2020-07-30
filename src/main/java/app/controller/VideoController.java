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


    @GetMapping
    public String allVideos(Model model){
        List<VideoPost> all = videoService.allVideoPosts();
        List<Category> categories = categoryService.allCategory();
        List<Post> posts = postService.limitPost();
        model.addAttribute("posts", posts);
        model.addAttribute("categories", categories);
        model.addAttribute("allVideos", all);
        return "tech-video";
    }
}
