package app.controller;

import app.entity.Category;
import app.service.CategoryService;
import app.service.EmailServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subscribe")
public class SubscribeController {

    private final EmailServiceImpl emailService;
    private final CategoryService categoryService;

    public SubscribeController(EmailServiceImpl emailService, CategoryService categoryService) {
        this.emailService = emailService;
        this.categoryService = categoryService;
    }

   @GetMapping
    public String handleGet(@RequestParam("email") String email, Model model){
       List<Category> categories = categoryService.allCategory();
       if (emailService.isBeforeSubscribed(email)){

       }
       emailService.sendEmail(email, "Tech Blog", "You have successfully subscribed to Tech Blog");
       model.addAttribute("categories", categories);
       model.addAttribute("email", email);
       return "tech-success";

   }


}
