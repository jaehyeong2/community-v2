package jaefactory.newboard.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jaefactory.newboard.domain.oauth.KakaoProfile;
import jaefactory.newboard.domain.oauth.OAuthToken;
import jaefactory.newboard.domain.user.User;
import jaefactory.newboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AuthController {

    @Value("${kakao.key}")
    private String kakaoKey;
    private String CLIENT_CODE = "19ec158ac89f2be7a8713d1bec482fb9";

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

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

        System.out.println("카카오 엑세스 토큰 : "+oAuthToken.getAccess_token());

        RestTemplate restTemplate2 = new RestTemplate();

        // HttpHeader 오브젝트 생성
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization", "Bearer "+oAuthToken.getAccess_token());
        headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");


        //헤더 바디 담기
        HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest =
                new HttpEntity<>(headers2);

        ResponseEntity<String> response2 = restTemplate2.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        ObjectMapper objectMapper2 = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//
//        log.info("카카오 아이디(번호) : {} ",kakaoProfile.getId());
//        log.info("카카오 이메일 : {} ",kakaoProfile.getKakao_account().getEmail();
//        log.info("블로그서버 유저네임 : {} ",kakaoProfile.getId());
//        log.info("블로그서버 이메일  : {} ",kakaoProfile.getId());
//        log.info("블로그서버 패스워드 : {} ",kakaoProfile.getId());
//
        System.out.println("카카오 아이디(번호) : "+kakaoProfile.getId());
        System.out.println("카카오 이메일 : "+kakaoProfile.getKakao_account().getEmail());

        System.out.println("블로그서버 유저네임 : "+kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId());
        System.out.println("블로그서버 이메일 : "+kakaoProfile.getKakao_account().getEmail());
        System.out.println("블로그서버 패스워드 : "+kakaoKey);

        User kakaoUser = User.builder()
                .username(kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId())
                .password(kakaoKey)
                .email(kakaoProfile.getKakao_account().getEmail())
                .oauth("kakao")
                .build();

        User originUser = userService.findUser(kakaoUser.getUsername());
        if(originUser.getUsername() == null) {
            userService.join(kakaoUser);
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(), kakaoKey));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/";
    }
}
