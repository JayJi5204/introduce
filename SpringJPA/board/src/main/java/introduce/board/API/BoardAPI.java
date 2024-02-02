package introduce.board.API;


import introduce.board.DTO.BoardDTO;
import introduce.board.Entity.BoardEntity;
import introduce.board.Repository.BoardRepository;
import introduce.board.Service.BoardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BoardAPI {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    //게시판 제목, 게시글 작성 API
    @PostMapping("/api/board")
    public CreateBoardResponse saveBoard(@RequestBody @Valid CreateBoardRequest request) {
        BoardDTO boardDTO = new BoardDTO(request.boarId, request.title, request.content, null, null, new ArrayList<>());
        Long boardId = boardService.saveBoardApi(boardDTO);
        return new CreateBoardResponse(boardId);
    }

    //게시글 수정 API
    @PutMapping("/api/board/{boardId}")
    public UpdateBoardResponse updateBoard(@PathVariable("boardId") Long boardId, @RequestBody @Valid UpdateBoardRequest request) {
        boardService.updateBoardApi(boardId, request.getTitle(), request.getContent());
        BoardEntity boardEntity = boardRepository.findById(boardId).orElseThrow();
        return new UpdateBoardResponse(boardEntity.getBoardId(), boardEntity.getTitle(), boardEntity.getContent());

    }

    //게시판 조회 API
    @GetMapping("/api/board")
    public Result<List<BoardDto>> board() {
        List<BoardEntity> findBoards = boardService.findBoardApi();
        List<BoardDto> collect = findBoards.stream().map(m -> new BoardDto(m.getBoardId(), m.getTitle(), m.getContent())).collect(Collectors.toList());
        return new Result<>(collect);
    }

    @Data
    static class CreateBoardResponse {
        private Long boardId;

        public CreateBoardResponse(Long boardId) {
            this.boardId = boardId;
        }
    }

    @Data
    static class CreateBoardRequest {
        private Long boarId;
        @NotEmpty
        private String title;
        @NotEmpty
        private String content;
    }

    @Data
    @AllArgsConstructor
    static class UpdateBoardResponse {
        private Long boardId;
        private String title;
        private String content;
    }

    @Data
    static class UpdateBoardRequest {
        @NotEmpty
        private String title;
        @NotEmpty
        private String content;
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class BoardDto {
        private Long boardId;
        private String title;
        private String content;
    }
}
