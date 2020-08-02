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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public String postDetail(@PathVariable("id") int id, Model model){
        List<Category> categories = categoryService.allCategory();
        List<Comment> comments = commentService.postComments(id);
        Post post = postService.getPost(id);
        model.addAttribute("comments", comments);
        model.addAttribute("categories", categories);
        model.addAttribute("post", post);
        return "tech-single";

    }

    @GetMapping("/detail/video/{id}")
    public String videoDetail(@PathVariable(name = "id") int id, Model model){
        List<Category> categories = categoryService.allCategory();
        VideoPost videoPost = videoService.getVideo(id);
        model.addAttribute("categories", categories);
        model.addAttribute("video", videoPost);
        return "tech-video-detail";

    }

    @PostMapping("/detail/post/{id}")
    public String postComment(@PathVariable("id") int id,
                              @RequestParam("fullName") String fullName,
                              @RequestParam("comment") String comment){
        String date = LocalDate.now().toString();
        commentService.save(new Comment(fullName, comment, date, new Post(id)));
        return "redirect:/detail/post/" + id;
    }
}
