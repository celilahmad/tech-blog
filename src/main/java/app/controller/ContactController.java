package app.controller;

import app.entity.Category;
import app.entity.Contact;
import app.service.CategoryService;
import app.service.ContactService;
import app.service.EmailServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;
    private final EmailServiceImpl emailService;
    private final CategoryService categoryService;

    public ContactController(ContactService contactService, EmailServiceImpl emailService, CategoryService categoryService) {
        this.contactService = contactService;
        this.emailService = emailService;
        this.categoryService = categoryService;
    }


    @PostMapping
    public String postContact(@ModelAttribute("contact") Contact contact, Model model){
        contactService.saveContact(contact);
        emailService.sendEmailToMe("tech.blog.smtp@gmail.com",
                                    contact.getEmail(),
                                    contact.getSubject(),
                                    contact.getContent());
        List<Category> all = categoryService.allCategory();
        model.addAttribute("categories", all);
        model.addAttribute("email", contact.getEmail());
        return "tech-success";
    }

}
