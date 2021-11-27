package jaefactory.newboard.controller.api;
import jaefactory.newboard.domain.comment.Comment;
import jaefactory.newboard.dto.CommentSaveRequestDto;
import jaefactory.newboard.dto.CommonResDto;
import jaefactory.newboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;

    @PostMapping("/api/board/{boardId}/comment")
    public ResponseEntity<?> commentSave(@RequestBody @Valid CommentSaveRequestDto commentSaveRequestDto, BindingResult bindingResult){
        commentService.saveComment(commentSaveRequestDto);
        return new ResponseEntity<>(new CommonResDto<>(1,"댓글작성완료","!"), HttpStatus.OK);
    }

    @DeleteMapping("/api/comment/{commentId}")
    public ResponseEntity<?> commentDelete(@PathVariable int commentId){
        commentService.deleteReplyById(commentId);
        return new ResponseEntity<>(new CommonResDto<>(1,"댓글삭제",null),HttpStatus.OK);
    }
}
