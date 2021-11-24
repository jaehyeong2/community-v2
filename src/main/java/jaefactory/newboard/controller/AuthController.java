package jaefactory.newboard.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jaefactory.newboard.domain.token.OAuthToken;
import jaefactory.newboard.domain.user.User;
import jaefactory.newboard.dto.SignUpDto;
import jaefactory.newboard.handler.exception.CustomValidationException;
import jaefactory.newboard.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;
    private String CLIENT_CODE = "19ec158ac89f2be7a8713d1bec482fb9";

    @GetMapping("/auth/signup")
    public String signUpForm() {
        return "/auth/signup";
    }

    @GetMapping("/auth/signin")
    public String signInForm() {
        return "/auth/signin";
    }

    @ResponseBody
    @GetMapping("/auth/kakao/callback")
    public String kakaoCallback(String code){

        RestTemplate restTemplate = new RestTemplate();

        //HTTP 헤더 오브젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        //HTTP 바디 오브젝트 생성
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id",CLIENT_CODE);
        params.add("redirect_url","http://localhost:8080/auth/kakao/callback");
        params.add("code",code);

        //헤더 바디 담기
        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =
                new HttpEntity<>(params,headers);


        ResponseEntity<String> response = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = null;
        try {
            oAuthToken = objectMapper.readValue(response.getBody(),OAuthToken.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "요청 값:"+response;
    }

    @PostMapping("/auth/signup")
    public String signUp(@Valid SignUpDto signUpDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationException("유효성 검사 실패", errorMap);
        } else {
            User user = signUpDto.toEntity();
            User userEntity = authService.join(user);
            return "/auth/signin";
        }
    }
}
