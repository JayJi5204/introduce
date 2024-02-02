package introduce.board.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boardId")
    @SequenceGenerator(name = "boardId", allocationSize = 1)
    @Column(name = "boardId")
    private Long boardId;    //글 번호

    private String title;   //글 제목

    private String content; //글 내용

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createAt; //작성일

    @LastModifiedDate
    private LocalDateTime fixAt;    //수정일

    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL)
    private List<ReplyEntity> replyEntities = new ArrayList<>();  //댓글 1:N 관계 설정

}
