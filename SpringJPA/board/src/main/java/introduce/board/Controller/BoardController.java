package introduce.board.Controller;

import introduce.board.Entity.BoardEntity;
import introduce.board.Form.BoardForm;
import introduce.board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    //게시글 작성
    @GetMapping("/board/write")
    public String GetBoardWritePage(Model model) {
        log.info("BoardWritePage");
        model.addAttribute("boardForm", new BoardForm());
        return "BoardWritePage";
    }

    /*    @PostMapping("/board/write")
        public String PostBoardWritePage(@Valid BoardForm boardForm) {
            boardService.saveBoard(boardForm.toEntity());
            return "redirect:/board";
        }*/
    @PostMapping("/board/write")
    public String PostBoardWritePage(@Valid BoardForm boardForm) {
        BoardEntity savedBoardEntity = boardService.saveBoard(boardForm.toEntity());
        boardForm.setCreateAt(savedBoardEntity.getCreateAt());
        boardForm.setFixAt(savedBoardEntity.getFixAt());
        return "redirect:/board";
    }


    //게시글 리스트 화면
    @GetMapping("/board")
    public String GetBoardPage(Model model) {
        log.info("BoardPage");
        List<BoardEntity> boardEntities = boardService.findBoard();
        model.addAttribute("boardEntities", boardEntities);
        return "BoardPage";
    }

    //각 번호 게시글
    @GetMapping("/board/{id}")
    public String GetBoard(@PathVariable("id") Long id, Model model) {
        Optional<BoardEntity> boardOptional = boardService.getBoard(id);
        BoardForm boardForm = BoardForm.boardForms(boardOptional.get());
        model.addAttribute("boardForm", boardForm);
        return "BoardIdPage";
    }
 /*   @PostMapping("/board/{id}")
    public String PostBoard(@PathVariable Long id, @ModelAttribute("boardForm") BoardForm boardForm) {
        BoardEntity boardEntity = boardForm.toEntity();
        boardEntity.setId(id); // 아이디를 설정해 주어야 합니다.
        boardService.saveBoard(boardEntity);
        return "redirect:/board/" + id;
    }*/

    @PostMapping("/board/{id}")
    public String PostBoard(@PathVariable Long id, @ModelAttribute("boardForm") BoardForm boardForm) {
        Optional<BoardEntity> boardOptional = boardService.getBoard(id);

        BoardEntity boardEntity = boardOptional.get();
        boardEntity.setTitle(boardForm.getTitle());
        boardEntity.setContent(boardForm.getContent());

        BoardEntity savedBoardEntity = boardService.saveBoard(boardEntity);

        boardForm.setCreateAt(savedBoardEntity.getCreateAt());
        boardForm.setFixAt(savedBoardEntity.getFixAt());
        return "redirect:/board/" + id;
    }


    //게시글 수정
    @GetMapping("/board/{id}/update")
    public String GetUpdateBoard(@PathVariable("id") Long id, Model model) {
        Optional<BoardEntity> boardOptional = boardService.getBoard(id);
        BoardForm boardForm = BoardForm.boardForms(boardOptional.get());
        model.addAttribute("boardForm", boardForm);
        return "BoardUpdatePage";
    }

    /*    @PostMapping("/board/{id}/update")
        public String PostUpdateBoard(@PathVariable Long id, @ModelAttribute("boardForm")BoardForm boardForm, Model model){
            BoardEntity boardEntity = boardForm.toEntity();
            boardEntity.setId(id);
            boardService.saveBoard(boardEntity);
            BoardForm updatedForm = BoardForm.boardForms(boardEntity);
            model.addAttribute("boardForm", updatedForm);
            return "redirect:/board/{id}/update";
        }*/
    @PostMapping("/board/{id}/update")
    public String PostUpdateBoard(@PathVariable Long id, @ModelAttribute("boardForm") BoardForm boardForm, Model model) {
        BoardEntity boardEntity = boardForm.toEntity();
        boardEntity.setId(id);
        BoardEntity updatedBoardEntity = boardService.saveBoard(boardEntity);
        BoardForm updatedForm = BoardForm.boardForms(updatedBoardEntity);
        model.addAttribute("boardForm", updatedForm);
        return "redirect:/board/" + id;
    }


    //게시글 삭제
 /* @GetMapping("/board/{id}/delete")
  public String GetBoardDelete(@PathVariable Long id,BoardForm boardForm){
      boardService.deleteBoard(boardForm.toEntity());
    return "redirect:/board";
    }
*/


    @GetMapping("/board/{id}/delete")
    public String GetBoardDelete(@PathVariable Long id) {
        Optional<BoardEntity> boardOptional = boardService.getBoard(id);
        boardService.deleteBoard(id);
        return "redirect:/board";
    }
}
