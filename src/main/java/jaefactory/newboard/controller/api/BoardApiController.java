package jaefactory.newboard.controller.api;

import jaefactory.newboard.config.auth.PrincipalDetails;
import jaefactory.newboard.domain.board.Board;
import jaefactory.newboard.dto.CommonResDto;
import jaefactory.newboard.dto.ReplySaveRequestDto;
import jaefactory.newboard.service.BoardService;
import jaefactory.newboard.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;
    private final ReplyService replyService;

    @PostMapping("/api/board")
    public CommonResDto<?> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetails principal){
        boardService.addBoard(board,principal.getUser());
        return new CommonResDto<Integer>(1,"ok",1);
    }

    @DeleteMapping("/api/board/{id}")
    public CommonResDto<?> delete(@PathVariable int id){
        boardService.deleteBoardById(id);
        return new CommonResDto<Integer>(1,"ok",1);
    }

    @PutMapping("/api/board/{id}")
    public CommonResDto<?> update(@PathVariable int id,@RequestBody Board board){
        boardService.updateBoardById(id,board);
        return new CommonResDto<Integer>(1,"ok",1);
    }

    //Reply
    @PostMapping("/api/board/{boardId}/reply")
    public CommonResDto<?> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto){
        replyService.saveReply(replySaveRequestDto);
        return new CommonResDto<Integer>(1,"ok",1);
    }

    @DeleteMapping("/api/board/{boardId}/reply/{replyId}")
    public CommonResDto<?> replyDeleteById(@PathVariable int replyId){
        replyService.deleteReplyById(replyId);
        return new CommonResDto<Integer>(1,"ok",1);
    }
}
