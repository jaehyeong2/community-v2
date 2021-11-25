package jaefactory.newboard.service;


import jaefactory.newboard.domain.user.User;
import jaefactory.newboard.domain.user.UserRepository;
import jaefactory.newboard.dto.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional(readOnly = true)
    public User findUser(String username){
        User user = userRepository.findByUsername(username).orElseGet(()->{
            return new User(); // 빈 객체 리턴
        });
        return user;
    }


    @Transactional
    public void userUpdate(User user) {
        User persistence = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException("회원 찾기 실패");
        });

        // Validate 체크 => oauth 필드에 값이 없으면 수정 가능
        if(persistence.getOauth() == null || persistence.getOauth().equals("")) {
            String rawPassword = user.getPassword();
            String encPassword = encoder.encode(rawPassword);
            persistence.setPassword(encPassword);
            persistence.setRealName(user.getRealName());
        }
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }
}
