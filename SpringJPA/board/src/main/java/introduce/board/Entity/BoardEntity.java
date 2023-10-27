package introduce.board.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserEntity_Id")
    private UserEntity userEntity;  //UserEntity

    @Embedded
    private DateEntity dateEntity;  //DateEntity


}
