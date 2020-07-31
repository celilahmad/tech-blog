package app.controller;

import app.service.EmailServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subscribe")
public class SubscribeController {

    private final EmailServiceImpl emailService;

    public SubscribeController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

   @GetMapping
    public String handleGet(){
        return "tech-index";

   }

   @PostMapping
    public String handleSubscribe(@RequestParam("email") String email) {
       emailService.sendEmail(email, "Tech Blog", "You have successfully subscribed to Tech Blog");
       return "tech-index";
   }
}
