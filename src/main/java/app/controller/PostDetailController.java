package app.controller;

import app.entity.Post;
import app.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostDetailController {

    private final PostService postService;

    public PostDetailController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/detail")
    public String newsDetail(@RequestParam(name = "id") int id, Model model){
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "tech-single";

    }
}
