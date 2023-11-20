package introduce.board.Controller;

import introduce.board.DTO.BoardDTO;
import introduce.board.DTO.ReplyDTO;
import introduce.board.Entity.BoardEntity;
import introduce.board.Entity.ReplyEntity;
import introduce.board.Service.BoardService;
import introduce.board.Service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;
    private final ReplyService replyService;

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




    //각 번호 게시글
    @Transactional
    @GetMapping("/board/{id}")
    public String GetBoard(@PathVariable("id") Long id, Model model) {
        Optional<BoardEntity> boardOptional = boardService.getBoard(id);
        BoardDTO boardForm = BoardDTO.boardForms(boardOptional.get());
        model.addAttribute("boardForm", boardForm);

        List<ReplyDTO> replyForms = replyService.getRepliesByBoardId(id);
        model.addAttribute("replyForms", replyForms);

        return "BoardIdPage";
    }


    @Transactional
    @PostMapping("/board/{id}")
    public String PostBoard(@PathVariable("id") Long id, @ModelAttribute("boardForm") BoardDTO boardForm) {
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
        return "redirect:/board/{id}";
    }


    //게시글 삭제
    @GetMapping("/board/{id}/delete")
    public String GetBoardDelete(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return "redirect:/board";
    }

    //게시글 리스트 화면
    @GetMapping("/board")
    public String GetBoardPage(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, String option, String keyword, Model model) {
        Page<BoardEntity> list = null;
        if (keyword == null) {
            list = boardService.findBoards(pageable);
        } else {
            list = boardService.searchBoards(option, keyword, pageable);
        }

        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 9, list.getTotalPages());

        model.addAttribute("search", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "BoardPage";
    }

    @PostMapping("/board/{boardId}/reply")
    public String createReply(@PathVariable("boardId") Long boardId, ReplyDTO replyForm) {
        replyService.saveReply(boardId, replyForm);
        return "redirect:/board/" + boardId;
    }



}
