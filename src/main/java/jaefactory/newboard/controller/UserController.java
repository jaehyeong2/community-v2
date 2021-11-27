package jaefactory.newboard.controller;

import jaefactory.newboard.domain.user.User;
import jaefactory.newboard.dto.SignUpDto;
import jaefactory.newboard.handler.exception.CustomValidationException;
import jaefactory.newboard.service.UserService;
import jaefactory.newboard.util.Script;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/user/signup")
    public String signUpForm() {
        return "/user/signup";
    }

    @GetMapping("/user/signin")
    public String signInForm() {
        return "/user/signin";
    }

    @PostMapping("/user/signup")
    public String signUp(@Valid SignUpDto signUpDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationException("유효성 검사 실패", errorMap);
        } else {
            User user = signUpDto.toEntity();
            User userEntity = userService.join(user);
            Script.success();
            return "/user/signin";
        }
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



