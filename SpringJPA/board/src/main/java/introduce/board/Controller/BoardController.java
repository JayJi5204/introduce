package introduce.board.Controller;

import introduce.board.Entity.BoardEntity;
import introduce.board.Entity.UserEntity;
import introduce.board.Form.BoardForm;
import introduce.board.Form.SignUpForm;
import introduce.board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/write")
    public String GetBoardWritePage(Model model) {
        log.info("BoardWritePage");
        model.addAttribute("boardForm", new BoardForm());
        return "BoardWritePage";
    }
    @PostMapping("/board/write")
    public String PostBoardWritePage(@Valid BoardForm boardForm) {
        log.info("BoardWritePage");
        BoardEntity boardEntity=new BoardEntity();
        boardEntity.setTitle(boardForm.getTitle());
        boardEntity.setContent(boardForm.getContent());
        boardService.saveBoard(boardEntity);
        return "redirect:/board";
    }

    @GetMapping("/board")
    public String boardPage(Model model) {
        log.info("BoardPage");
        List<BoardEntity> boardEntities=boardService.findBoard();
        model.addAttribute("boardEntities",boardEntities);
        return "BoardPage";
    }



}
