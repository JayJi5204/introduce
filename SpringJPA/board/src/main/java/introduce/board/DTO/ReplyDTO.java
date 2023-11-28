package introduce.board.DTO;

import introduce.board.Entity.ReplyEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyDTO {

    private Long id;
    private String replyContent;
    private LocalDateTime replyCreateAt;
    private Long boardId;

    public static ReplyDTO fromEntity(ReplyEntity replyEntity) {
        return new ReplyDTO(
                replyEntity.getReplyId(),
                replyEntity.getReplyContent(),
                replyEntity.getReplyCreateAt(),
                replyEntity.getBoardEntity().getId()
        );
    }

    // 생성자를 이용하여 필수 필드 초기화
    public ReplyDTO(Long id, String replyContent, LocalDateTime replyCreateAt, Long boardId) {
        this.id = id;
        this.replyContent = replyContent;
        this.replyCreateAt = replyCreateAt;
        this.boardId = boardId;
    }
}