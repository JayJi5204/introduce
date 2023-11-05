package introduce.board.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Board_Id")
    @SequenceGenerator(name = "Board_Id", allocationSize = 1)
    @Column(name = "BoardEntity_Id")
    private Long id;    //글 번호

    private String title;   //글 제목

    private String content; //글 내용

    @CreationTimestamp
    private LocalDateTime createAt; //작성일

    @UpdateTimestamp
    private LocalDateTime fixAt;    //수정일

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserEntity_Id")
    private UserEntity userEntity;  //UserEntity



}
