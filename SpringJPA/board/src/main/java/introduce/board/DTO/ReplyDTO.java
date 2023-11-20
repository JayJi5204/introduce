package introduce.board.DTO;

import introduce.board.Entity.BoardEntity;
import introduce.board.Entity.ReplyEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReplyDTO {

    private Long id;
    private String replyContent;
    private LocalDateTime replyCreateAt;
    private Long boardId;

    public static ReplyDTO replyForms(ReplyEntity replyEntity) {
        ReplyDTO replyForm = new ReplyDTO();
        replyForm.setId(replyEntity.getReplyId());
        replyForm.setReplyContent(replyEntity.getReplyContent());
        replyForm.setReplyCreateAt(replyEntity.getReplyCreateAt());
        replyForm.setBoardId(replyEntity.getBoardEntity().getId());
        return replyForm;
    }

    public ReplyEntity toEntity() {
        ReplyEntity replyEntity = new ReplyEntity();
        replyEntity.setReplyId(this.id);
        replyEntity.setReplyContent(this.replyContent);
        return replyEntity;
    }
}
