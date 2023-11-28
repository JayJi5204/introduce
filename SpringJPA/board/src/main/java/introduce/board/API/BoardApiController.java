package introduce.board.API;

import introduce.board.DTO.BoardDTO;
import introduce.board.DTO.ReplyDTO;
import introduce.board.Service.BoardService;
import introduce.board.Service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
@Slf4j
public class BoardApiController {

    private final BoardService boardService;
    private final ReplyService replyService;

    // 게시글 작성
    @PostMapping
    public ResponseEntity<Void> createBoard(@Valid @RequestBody BoardDTO boardForm) {
        boardService.saveBoard(boardForm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 각 번호 게시글 조회
    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getBoard(@PathVariable("id") Long id) {
        Optional<BoardDTO> boardOptional = boardService.getBoard(id);
        return boardOptional.map(boardDTO -> new ResponseEntity<>(boardDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBoard(@PathVariable("id") Long id, @RequestBody BoardDTO boardForm) {
        boardService.saveBoard(boardForm);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 게시글 리스트 조회
    @GetMapping
    public ResponseEntity<Page<BoardDTO>> getBoardPage(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            String option, String keyword) {
        Page<BoardDTO> list;
        if (keyword == null) {
            list = boardService.findBoards(pageable);
        } else {
            list = boardService.searchBoards(option, keyword, pageable);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 댓글 작성
    @PostMapping("/{boardId}/replies")
    public ResponseEntity<Void> createReply(@PathVariable("boardId") Long boardId, @RequestBody ReplyDTO replyForm) {
        replyService.saveReply(boardId, replyForm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
