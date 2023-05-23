package myStudyspring.myStudyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute( "data", "hello!!!");
        return "hello"; //hello.html에 가서 렌더링하라는 뜻.
    }
}
