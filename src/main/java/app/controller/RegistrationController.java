package app.controller;

import app.entity.User;
import app.exception.UserAlreadyExistException;
import app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registerPage(){
        return "registration";
    }

    @PostMapping
    public ModelAndView handle_post(@Valid @ModelAttribute(value = "user") User user, BindingResult result) {
        if (result.hasErrors())
            return new ModelAndView("registration", "user", user);
        if (userService.isRegistered(user.getEmail()))
            throw new UserAlreadyExistException("There is an account with that email address:" + user.getEmail());
        userService.saveUser(user);
        return new ModelAndView("tech-successRegister", "successRegister", user);
    }

    @GetMapping("successRegister")
    public String getSuccessRegisterPage() {
        return "tech-successRegister";
    }

}
