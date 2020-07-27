package app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/robotic")
public class RoboticController {

    @GetMapping
    public String allRoboticNews(){
        return "tech-contact";
    }
}
