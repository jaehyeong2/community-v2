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
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional(readOnly = true)
    public UserProfileDto userProfile(int pageUserId, int principalId) {
        UserProfileDto dto = new UserProfileDto();

        User userEntity = userRepository.findById(pageUserId).get();

        dto.setUser(userEntity);
        dto.setPageOwnerState(pageUserId == principalId);

        return dto;
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }
}
