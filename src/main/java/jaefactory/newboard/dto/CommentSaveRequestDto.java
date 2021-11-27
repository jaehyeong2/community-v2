package jaefactory.newboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentSaveRequestDto {

    private int userId;
    private int boardId;
    private String content;
}
