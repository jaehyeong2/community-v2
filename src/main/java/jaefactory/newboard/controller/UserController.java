package jaefactory.newboard.controller;

import jaefactory.newboard.config.auth.PrincipalDetails;
import jaefactory.newboard.service.BoardService;
import jaefactory.newboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    @GetMapping("/user/signup")
    public String signUpForm() {
        return "/user/signup";
    }

    @GetMapping("/user/signin")
    public String signInForm() {
        return "/user/signin";
    }

    @GetMapping("/user/{id}")
    public String profile(@PathVariable long id){
        return "profile";
    }

    @GetMapping("/user/update")
    public String update(){
        return "/user/updateForm";
    }

    @PostMapping("/user/update")
    public String updatePost(){
        return "/user/updateForm";
    }
}



