package jaefactory.newboard.dto;

import jaefactory.newboard.domain.user.User;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignUpDto {
    @Size(min = 2, max = 20)
    @NotBlank
    private String username;
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

    public User toEntity() {
        return User.builder()
                .username(username).name(name).password(password).email(email)
                .build();
    }

}
