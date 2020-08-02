package app.controller;

import app.entity.Category;
import app.entity.Comment;
import app.entity.Post;
import app.service.CategoryService;
import app.service.CommentService;
import app.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
public class CommentController {

    private final CommentService commentService;
    private final CategoryService categoryService;
    private final PostService postService;

    public CommentController(CommentService commentService, CategoryService categoryService, PostService postService) {
        this.commentService = commentService;
        this.categoryService = categoryService;
        this.postService = postService;
    }

    /*@GetMapping("/detail/post/{id}")
    public String postDetail(@PathVariable("id") int id, Model model){
        List<Category> categories = categoryService.allCategory();
        List<Comment> comments = commentService.postComments(id);
        Post post = postService.getPost(id);
        model.addAttribute("comments", comments);
        model.addAttribute("categories", categories);
        model.addAttribute("post", post);
        return "tech-single";

    }

    @PostMapping("/detail/post/{id}")
    public String postComment(@PathVariable("id") int id, @ModelAttribute("comment") Comment comment, BindingResult result){
        if (result.hasErrors())
            return "tech-single";
        String date = LocalDate.now().toString();
        comment.setDate(date);
        commentService.save(comment);
        return "redirect:/detail/post/" + id;
    }*/
}
