package introduce.board.Form;


import introduce.board.Entity.BoardEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;


@Getter
@Setter
public class BoardForm {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime fixAt;

    public static BoardForm boardForms(BoardEntity boardEntity) {
        BoardForm boardForm = new BoardForm();
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
        boardEntity.setTitle(this.title);
        boardEntity.setContent(this.content);
        boardEntity.setCreateAt(this.createAt);
        boardEntity.setFixAt(this.fixAt);
        return boardEntity;
    }
}
