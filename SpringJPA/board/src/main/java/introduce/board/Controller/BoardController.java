package introduce.board.Controller;

import introduce.board.DTO.BoardDTO;
import introduce.board.DTO.ReplyDTO;
import introduce.board.Entity.BoardEntity;
import introduce.board.Entity.ReplyEntity;
import introduce.board.Service.BoardService;
import introduce.board.Service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final ReplyService replyService;

    //게시글 리스트 화면
    @GetMapping("/board")
    public String getBoardPage(
            @PageableDefault(page = 0, size = 10, sort = "boardId", direction = Sort.Direction.DESC) Pageable pageable,
            String option, String keyword, Model model
    ) {
        Page<BoardEntity> list;

        if (keyword == null) {  //검색한 결과가 없으면
            list = boardService.findBoards(pageable);   //게시글 전체 보여주기
        } else {
            list = boardService.searchBoards(option, keyword, pageable);    //검색 결과 보여주기
        }

        int nowPage = list.getNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 9, list.getTotalPages()) - 1;

        model.addAttribute("search", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalPages", list.getTotalPages());

        return "BoardPage";
    }

    //게시글 작성
    @GetMapping("/board/write")
    public String GetBoardWritePage(Model model, Long boardId, String title, String content, LocalDateTime createAt, LocalDateTime fixAt) {
        model.addAttribute("boardForm", new BoardDTO(boardId, title, content, createAt, fixAt, new ArrayList<>()));
        return "BoardWritePage";
    }


    @PostMapping("/board/write")
    public String PostBoardWritePage(BoardDTO boardForm) {
        boardService.saveBoard(boardForm);
        return "redirect:/board";
    }

    //각 번호 게시글
    @GetMapping("/board/{boardId}")
    public String GetBoard(@PathVariable("boardId") Long boardId, Model model, BoardDTO boardDTO) {
        List<BoardEntity> boardEntities = boardService.getBoard();
        model.addAttribute("boardForm", boardEntities);

        Long id = boardDTO.getBoardId();
        model.addAttribute("Id", id);

        List<ReplyEntity> replyForms = replyService.getRepliesByBoardId(boardId);
        model.addAttribute("replyForms", replyForms);

        return "BoardIdPage";
    }

    @PostMapping("/board/{boardId}")
    public String PostBoard(@PathVariable("boardId") Long boardId, @ModelAttribute("boardForm") BoardDTO boardForm) {
        boardService.saveBoard(boardForm);
        return "redirect:/board/" + boardId;
    }

    //게시글 수정
    @GetMapping("/board/{boardId}/update")
    public String GetUpdateBoard(@PathVariable("boardId") Long boardId, Model model, BoardDTO boardDTO) {
        Long id = boardDTO.getBoardId();
        model.addAttribute("Id", id);
        List<BoardEntity> boardEntities = boardService.getBoard();
        model.addAttribute("boardForm", boardEntities);
        return "BoardUpdatePage";
    }

    @PostMapping("/board/{boardId}/update")
    public String PostUpdateBoard(@ModelAttribute("boardDTO") BoardDTO boardDTO) {
        boardService.saveBoard(boardDTO);
        return "redirect:/board/{boarId}";
    }

    //게시글 삭제
    @GetMapping("/board/{boardId}/delete")
    public String GetBoardDelete(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return "redirect:/board";
    }


    @PostMapping("/board/{boardId}/reply")
    public String createReply(@PathVariable("boardId") Long boardId, ReplyDTO replyForm) {
        replyService.saveReply(replyForm, boardId);
        return "redirect:/board/" + boardId;
    }
}
