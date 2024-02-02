package introduce.board.DTO;

import introduce.board.Entity.BoardEntity;
import introduce.board.Entity.ReplyEntity;
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


    public static ReplyDTO toReplyDTO(ReplyEntity replyEntity) {
        return new ReplyDTO(
                replyEntity.getReplyId(),
                replyEntity.getReplyContent(),
                replyEntity.getReplyCreateAt(),
                replyEntity.getBoardEntity()
        );
    }


}