package introduce.board.API;


import introduce.board.DTO.BoardDTO;
import introduce.board.Entity.BoardEntity;
import introduce.board.Service.BoardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BoardAPI {

    private final BoardService boardService;

    //게시판 제목, 게시글 API
    @PostMapping("/api/board")
    public CreateBoardResponse saveBoard(@RequestBody @Valid CreateBoardRequest request) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle(request.getTitle());
        boardDTO.setContent(request.getContent());
        Long id = boardService.saveBoard(boardDTO);
        return new CreateBoardResponse(id);
    }



    @Data
    static class CreateBoardResponse {
        private Long id;

        public CreateBoardResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class CreateBoardRequest {
        @NotEmpty
        private String title;
        private String content;
    }

    //게시글 수정 API
    @PutMapping("/api/board/{id}")
    public UpdateBoardResponse updateBoard(@PathVariable("id") Long id, @RequestBody @Valid UpdateBoardRequest request) {
        boardService.apiUpdate(id, request.getTitle());
        Optional<BoardEntity> boardEntity = boardService.findOne(id);
        BoardEntity getBoardEntity = boardEntity.get();
        return new UpdateBoardResponse(getBoardEntity.getId(), getBoardEntity.getTitle());

    }

    @Data
    @AllArgsConstructor
    static class UpdateBoardResponse {
        private Long id;
        private String title;
    }

    @Data
    static class UpdateBoardRequest {
        @NotEmpty
        private String title;
    }

    //게시판 조회 API
    @GetMapping("/api/board")
    public Result<List<BoardDto>> board() {
        List<BoardEntity> findBoards = boardService.findBoard();
        List<BoardDto> collect = findBoards.stream().map(m -> new BoardDto(m.getTitle())).collect(Collectors.toList());
        return new Result<>(collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class BoardDto {
        private String title;
    }
}
