package jaefactory.newboard.controller;

import jaefactory.newboard.dto.BoardDto;
import jaefactory.newboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final BoardService boardService;

    @GetMapping("/admin")
    public String adminHome(){
        return "admin";
    }

    @GetMapping("/admin/boards/add")
    public String boardAddGet(Model model){
        model.addAttribute("boardDto",new BoardDto());
//        model.addAttribute("categories",categoryService.getAllCategories());
        return "boardSave";
    }

}
