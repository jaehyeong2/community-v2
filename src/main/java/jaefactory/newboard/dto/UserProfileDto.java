package jaefactory.newboard.dto;

import jaefactory.newboard.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileDto {
    private User user;
    private boolean pageOwnerState;
}
