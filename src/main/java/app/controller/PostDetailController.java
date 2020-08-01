package app.controller;

import app.entity.Category;
import app.entity.Comment;
import app.entity.Post;
import app.entity.VideoPost;
import app.service.CategoryService;
import app.service.CommentService;
import app.service.PostService;
import app.service.VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class PostDetailController {

    private final PostService postService;
    private final CategoryService categoryService;
    private final VideoService videoService;
    private final CommentService commentService;

    public PostDetailController(PostService postService, CategoryService categoryService, VideoService videoService, CommentService commentService) {
        this.postService = postService;
        this.categoryService = categoryService;
        this.videoService = videoService;
        this.commentService = commentService;
    }

    @GetMapping("/detail/post/{id}")
    public String postDetail(@ModelAttribute(name = "id") int id, Model model){
        List<Category> categories = categoryService.allCategory();
        List<Comment> comments = commentService.postComments(id);
        Post post = postService.getPost(id);
        model.addAttribute("comments", comments);
        model.addAttribute("categories", categories);
        model.addAttribute("post", post);
        return "tech-single";

    }

    @GetMapping("/detail/video/{id}")
    public String videoDetail(@ModelAttribute(name = "id") int id, Model model){
        List<Category> categories = categoryService.allCategory();
        VideoPost videoPost = videoService.getVideo(id);
        model.addAttribute("categories", categories);
        model.addAttribute("video", videoPost);
        return "tech-video-detail";

    }
}
