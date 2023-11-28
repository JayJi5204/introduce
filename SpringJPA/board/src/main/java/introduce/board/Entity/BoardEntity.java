package introduce.board.Entity;

import lombok.Getter;
import lombok.Setter;
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
@EntityListeners(AuditingEntityListener.class)
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Board_Id")
    @SequenceGenerator(name = "Board_Id", allocationSize = 1)
    @Column(name = "BoardEntity_Id")
    private Long id;    //글 번호

    private String title;   //글 제목

    private String content; //글 내용

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createAt; //작성일

    @LastModifiedDate
    private LocalDateTime fixAt;    //수정일

    @OneToMany(mappedBy = "boardEntity",cascade = CascadeType.ALL)
    private List<ReplyEntity> replyEntities=new ArrayList<>();
}
