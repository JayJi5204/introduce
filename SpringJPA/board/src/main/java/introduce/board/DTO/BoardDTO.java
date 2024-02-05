package introduce.board.DTO;


import introduce.board.Entity.ReplyEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class BoardDTO {
    private Long boardId;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime fixAt;
    private List<ReplyEntity> replyEntity;

    public BoardDTO(Long boardId, String title, String content, LocalDateTime createAt, LocalDateTime fixAt, List<ReplyEntity> replyEntity) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.fixAt = fixAt;
        this.replyEntity = replyEntity;
    }


}


