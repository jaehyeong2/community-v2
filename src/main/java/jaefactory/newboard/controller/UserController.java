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

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final BoardService boardService;

    @GetMapping("/user/{id}")
    public String profile(@PathVariable long id){
        return "profile";
    }

    @GetMapping("/user/{id}/update")
    public String profileUpdate(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model){
        model.addAttribute("principal",principalDetails.getUser());
        return "profile";
    }
}



