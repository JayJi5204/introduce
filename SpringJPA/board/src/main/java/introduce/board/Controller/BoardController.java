package introduce.board.Controller;

import introduce.board.DTO.BoardDTO;
import introduce.board.Entity.BoardEntity;
import introduce.board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    //게시글 작성
    @GetMapping("/board/write")
    public String GetBoardWritePage(Model model) {
        model.addAttribute("boardForm", new BoardDTO());
        return "BoardWritePage";
    }

    @PostMapping("/board/write")
    public String PostBoardWritePage(@Valid BoardDTO boardForm) {
        BoardEntity savedBoardEntity = boardService.saveBoard(boardForm.toEntity());
        boardForm.setCreateAt(savedBoardEntity.getCreateAt());
        boardForm.setFixAt(savedBoardEntity.getFixAt());
        return "redirect:/board";
    }


    //게시글 리스트 화면
    @GetMapping("/board")
    public String GetBoardPage(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<BoardEntity> boardPage = boardService.findBoards(page);
        model.addAttribute("boardEntities", boardPage);
        return "BoardPage";
    }


    //각 번호 게시글
    @GetMapping("/board/{id}")
    public String GetBoard(@PathVariable("id") Long id, Model model) {
        Optional<BoardEntity> boardOptional = boardService.getBoard(id);
        BoardDTO boardForm = BoardDTO.boardForms(boardOptional.get());
        model.addAttribute("boardForm", boardForm);
        return "BoardIdPage";
    }


    @PostMapping("/board/{id}")
    public String PostBoard(@PathVariable("id")  Long id, @ModelAttribute("boardForm") BoardDTO boardForm) {
        Optional<BoardEntity> boardOptional = boardService.getBoard(id);
        BoardEntity boardEntity = boardOptional.get();

        boardEntity.setTitle(boardForm.getTitle());
        boardEntity.setContent(boardForm.getContent());
        boardService.saveBoard(boardEntity);
        return "redirect:/board/" + id;
    }


    //게시글 수정
    @GetMapping("/board/{id}/update")
    public String GetUpdateBoard(@PathVariable("id") Long id, Model model) {
        Optional<BoardEntity> boardOptional = boardService.getBoard(id);
        BoardDTO boardForm = BoardDTO.boardForms(boardOptional.get());
        model.addAttribute("boardForm", boardForm);
        return "BoardUpdatePage";
    }


    @PostMapping("/board/{id}/update")
    public String PostUpdateBoard() {
        log.info("TestPage2");
        return "redirect:/board/{id}";

    }


    //게시글 삭제
    @GetMapping("/board/{id}/delete")
    public String GetBoardDelete(@PathVariable Long id) {
        Optional<BoardEntity> boardOptional = boardService.getBoard(id);
        boardService.deleteBoard(id);
        return "redirect:/board";
    }


}
