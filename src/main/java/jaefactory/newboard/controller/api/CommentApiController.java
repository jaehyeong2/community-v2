package jaefactory.newboard.controller.api;
import jaefactory.newboard.dto.CommentSaveRequestDto;
import jaefactory.newboard.dto.CommonResDto;
import jaefactory.newboard.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final ReplyService replyService;

    //Reply
    @PostMapping("/api/board/{boardId}/comment")
    public CommonResDto<?> commentSave(@RequestBody CommentSaveRequestDto commentSaveRequestDto){
        replyService.saveComment(commentSaveRequestDto);
        return new CommonResDto<Integer>(1,"ok",1);
    }

    @DeleteMapping("/api/comment/{commentId}")
    public CommonResDto<?> commentDelete(@PathVariable int commentId){
        replyService.deleteReplyById(commentId);
        return new CommonResDto<Integer>(1,"ok",1);
    }
}
