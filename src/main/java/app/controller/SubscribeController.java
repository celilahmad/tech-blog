package app.controller;

import app.entity.Category;
import app.exception.EmailAlreadyExist;
import app.service.CategoryService;
import app.service.EmailServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    /*@GetMapping
    public String handleGet(){
        return "tech-index";
    }*/

   @GetMapping
    public String handleGet(@RequestParam("email") String email, Model model){
       List<Category> categories = categoryService.allCategory();
       /*if (result.hasErrors())
           return new ModelAndView("tech-index", "email", email);
       if (emailService.isAlreadySubscribed(email)){
            throw new EmailAlreadyExist(email + " already subscribed");
       }*/
       if (emailService.isAlreadySubscribed(email)){
           throw new EmailAlreadyExist(email + " already subscribed");
       }else {
           emailService.sendEmail(email, "Tech Blog", "You have successfully subscribed to Tech Blog");
           model.addAttribute("categories", categories);
           model.addAttribute("email", email);
       }
       return "tech-success";

   }


}
