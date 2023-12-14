// ReplyEntity
package introduce.board.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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
    private BoardEntity boardEntity;    //게시판 N:1 관계 설정

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BoardEntity2_Id")
    private BoardEntity2 boardEntity2;    //게시판 N:1 관계 설정

    // 생성자를 이용하여 필수 필드 초기화
    public ReplyEntity(String replyContent, LocalDateTime replyCreateAt, BoardEntity boardEntity) {
        this.replyContent = replyContent;
        this.replyCreateAt = replyCreateAt;
        this.boardEntity = boardEntity;
    }
}