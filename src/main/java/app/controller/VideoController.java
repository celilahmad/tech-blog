package app.controller;

import app.entity.Category;
import app.entity.VideoPost;
import app.service.CategoryService;
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

    public VideoController(VideoService videoService, CategoryService categoryService) {
        this.videoService = videoService;
        this.categoryService = categoryService;
    }


    @GetMapping
    public String allVideos(Model model){
        List<VideoPost> all = videoService.allVideoPosts();
        List<Category> categories = categoryService.allCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("allVideos", all);
        return "tech-video";
    }
}
