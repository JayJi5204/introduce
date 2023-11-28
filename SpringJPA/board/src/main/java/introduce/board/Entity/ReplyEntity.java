// ReplyEntity
package introduce.board.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Reply_Id")
    @SequenceGenerator(name = "Reply_Id", allocationSize = 1)
    @Column(name = "ReplyEntity_Id")
    private Long replyId;    // 댓글 번호

    private String replyContent;    // 댓글 내용

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime replyCreateAt; // 작성일

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BoardEntity_Id")
    private BoardEntity boardEntity;

    // 생성자를 이용하여 필수 필드 초기화
    public ReplyEntity(String replyContent, LocalDateTime replyCreateAt, BoardEntity boardEntity) {
        this.replyContent = replyContent;
        this.replyCreateAt = replyCreateAt;
        this.boardEntity = boardEntity;
    }
}