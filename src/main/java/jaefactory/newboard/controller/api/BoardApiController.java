package jaefactory.newboard.controller.api;

import jaefactory.newboard.config.auth.PrincipalDetails;
import jaefactory.newboard.domain.board.Board;
import jaefactory.newboard.dto.CommonResDto;
import jaefactory.newboard.service.BoardService;
import jaefactory.newboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;
    private final CommentService commentService;

    @PostMapping("/api/board")
    public ResponseEntity<?> save(@RequestBody @Valid Board board, @AuthenticationPrincipal PrincipalDetails principal){
        boardService.addBoard(board,principal.getUser());
        return new ResponseEntity<>(new CommonResDto<>(1,"글 작성 완료",1), HttpStatus.OK);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        boardService.deleteBoardById(id);
        return new ResponseEntity<>(new CommonResDto<Integer>(1,"글 삭제 완료",1),HttpStatus.OK);
    }

    @PutMapping("/api/board/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Board board){
        boardService.updateBoardById(id,board);
        return new ResponseEntity<>(new CommonResDto<>(1,"글 수정 완료",1),HttpStatus.OK);
    }
}
