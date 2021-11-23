package jaefactory.newboard.controller;


import jaefactory.newboard.domain.user.User;
import jaefactory.newboard.dto.SignUpDto;
import jaefactory.newboard.handler.exception.CustomValidationException;
import jaefactory.newboard.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class AuthController {

//    private final AuthService authService;
//
//    @GetMapping("/signup")
//    public String signUpForm() {
//        return "signup";
//    }
//
//    @GetMapping("/signin")
//    public String signInForm() {
//        return "signin";
//    }
//
//    @PostMapping("/signup")
//    public String signUp(@Valid SignUpDto signUpDto, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errorMap = new HashMap<>();
//
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//            }
//            throw new CustomValidationException("유효성 검사 실패", errorMap);
//        } else {
//            User user = signUpDto.toEntity();
//            User userEntity = authService.join(user);
//            return "signin";
//        }
//    }
}
