package introduce.board.DTO;

import introduce.board.Entity.BoardEntity;
import introduce.board.Entity.BoardEntity2;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDTO2 {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime fixAt;

    // Constructor with parameters
    public BoardDTO2(Long id, String title, String content, LocalDateTime createAt, LocalDateTime fixAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.fixAt = fixAt;
    }

    // Static method to convert Entity to DTO
    public static BoardDTO2 toBoardDTO(BoardEntity2 boardEntity) {
        return new BoardDTO2(
                boardEntity.getId(),
                boardEntity.getTitle(),
                boardEntity.getContent(),
                boardEntity.getCreateAt(),
                boardEntity.getFixAt()
        );
    }
}
