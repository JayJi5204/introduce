package introduce.board.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReplyEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Reply_Id")
    @SequenceGenerator(name = "Reply_Id", allocationSize = 1)
    @Column(name = "ReplyEntity_Id")
    private Long id;    //댓글 번호

    private String replyContent;    //댓글 내용


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BoardEntity_Id")
    private BoardEntity boardEntity;


    public void ChangeReply(String replyContent){
        this.replyContent=replyContent;

    }



}
