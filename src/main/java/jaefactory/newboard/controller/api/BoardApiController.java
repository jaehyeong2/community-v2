package jaefactory.newboard.controller.api;

import jaefactory.newboard.config.auth.PrincipalDetails;
import jaefactory.newboard.domain.board.Board;
import jaefactory.newboard.dto.BoardDto;
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
    public BoardDto<?> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetails principal){
        boardService.addBoard(board,principal.getUser());
        return new BoardDto<Integer>(1,1);
    }

    @DeleteMapping("/api/board/(id)")
    public BoardDto<?> delete(@PathVariable int id){
        boardService.deleteBoardById(id);
        return new BoardDto<Integer>(1,1);
    }

    @PutMapping("/api/board/{id}")
    public BoardDto<?> update(@PathVariable int id,@RequestBody Board board){
        boardService.updateBoardById(id,board);
        return new BoardDto<Integer>(1,-1);
    }

    //Reply
    @PostMapping("/api/board/{boardId}/reply")
    public BoardDto<?> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto){
        replyService.saveReply(replySaveRequestDto);
        return new BoardDto<Integer>(1,1);
    }

    @DeleteMapping("/api/board/{boardId}/reply/{replyId}")
    public BoardDto<?> replyDeleteById(@PathVariable int replyId){
        replyService.deleteReplyById(replyId);
        return new BoardDto<Integer>(1,1);
    }
}
