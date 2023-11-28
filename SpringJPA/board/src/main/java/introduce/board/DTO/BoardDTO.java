package introduce.board.DTO;


import introduce.board.Entity.BoardEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class BoardDTO {
    private Long id;
    private String Title;
    private String Content;
    private LocalDateTime createAt;
    private LocalDateTime fixAt;

    public static BoardDTO boardForms(BoardEntity boardEntity) {
        BoardDTO boardForm = new BoardDTO();
        boardForm.setId(boardEntity.getId());
        boardForm.setTitle(boardEntity.getTitle());
        boardForm.setContent(boardEntity.getContent());
        boardForm.setCreateAt(boardEntity.getCreateAt());
        boardForm.setFixAt(boardEntity.getFixAt());
        return boardForm;
    }

    public BoardEntity toEntity() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(this.id);
        boardEntity.setTitle(this.Title);
        boardEntity.setContent(this.Content);
        boardEntity.setCreateAt(this.createAt);
        boardEntity.setFixAt(this.fixAt);
        return boardEntity;
    }
}


