package jaefactory.newboard.controller;

import jaefactory.newboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/add")
    public String addBoardGet(){
        return "/board/saveForm";
    }

    @GetMapping("/board/{boardId}")
    public String boardDetail(@PathVariable Long boardId, Model model) {
        model.addAttribute("board",boardService.getBoardById(boardId));
        return "/board/detail";
    }

    @GetMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.getBoardById(id));
        return "/board/updateForm";
    }
}
