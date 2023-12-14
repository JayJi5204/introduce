package introduce.board.DTO;


import introduce.board.Entity.BoardEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime fixAt;

    // 생성자를 이용하여 필수 필드 초기화
    public BoardEntity toEntity() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(this.id);
        boardEntity.setTitle(this.title);
        boardEntity.setContent(this.content);
        boardEntity.setCreateAt(this.createAt);
        boardEntity.setFixAt(this.fixAt);
        return boardEntity;
    }

    //DTO를 Entity로 변환
    public static BoardDTO toBoardEntity(BoardEntity boardEntity) {
        BoardDTO boardForm = new BoardDTO();
        boardForm.setId(boardEntity.getId());
        boardForm.setTitle(boardEntity.getTitle());
        boardForm.setContent(boardEntity.getContent());
        boardForm.setCreateAt(boardEntity.getCreateAt());
        boardForm.setFixAt(boardEntity.getFixAt());
        return boardForm;
    }


}


