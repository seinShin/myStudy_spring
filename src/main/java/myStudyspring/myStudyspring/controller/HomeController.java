package myStudyspring.myStudyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")    ///도메인
    public String home(){
        return "home";
    }
}
