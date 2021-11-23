package jaefactory.newboard.controller;

import jaefactory.newboard.config.auth.PrincipalDetails;
import jaefactory.newboard.service.BoardService;
import jaefactory.newboard.service.ReplyService;
import jaefactory.newboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final UserService userService;
    private final ReplyService replyService;
    private final BoardService boardService;


//    @GetMapping("/board/add")
//    public String addBoardGet(Model model){
//
////        board.setCategory(categoryService.getCategoryById(boardDto.getCategoryId()).get());
////        model.addAttribute("boardDto",new BoardDto());
////        model.addAttribute("board",new Board());
//        return "boardSave";
//    }
//
//    @GetMapping("/board/detail/{boardId}")
//    public String boardDetail(@PathVariable int boardId,Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
//        model.addAttribute("board",boardService.getBoardById(boardId));
//        model.addAttribute("user",principalDetails);
//        model.addAttribute("replies",replyService.getAllRepliesByBoardId(boardId));
//        return "boardDetails";
//    }
//
//    @GetMapping("/board/update/{id}")
//    public String boardUpdate(@PathVariable int id, Model model) {
//        model.addAttribute("board", boardService.getBoardById(id));
//        return "boardUpdate";
//    }
//
}
