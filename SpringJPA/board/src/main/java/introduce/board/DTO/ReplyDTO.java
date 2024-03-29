package introduce.board.DTO;

import introduce.board.Entity.BoardEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyDTO {

    private Long id;
    private String replyContent;
    private LocalDateTime replyCreateAt;
    private BoardEntity boardEntity;

    public ReplyDTO(Long id, String replyContent, LocalDateTime replyCreateAt, BoardEntity boardEntity) {
        this.id = id;
        this.replyContent = replyContent;
        this.replyCreateAt = replyCreateAt;
        this.boardEntity = boardEntity;
    }

}