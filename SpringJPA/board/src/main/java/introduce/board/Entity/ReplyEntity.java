package introduce.board.Entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Reply_Id")
    @SequenceGenerator(name = "Reply_Id", allocationSize = 1)
    @Column(name = "ReplyEntity_Id")
    private Long replyId;    //댓글 번호

    private String replyContent;    //댓글 내용

    @CreatedDate
    private LocalDateTime replyCreateAt; //작성일

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BoardEntity_Id")
    private BoardEntity boardEntity;


}
