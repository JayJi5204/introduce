package introduce.board.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "User_Id")
    @SequenceGenerator(name = "User_Id", allocationSize = 1)
    @Column(name = "UserEntity_Id")
    private Long id;    //유저 번호

    private String userName;    //유저 이름

    private String userEmail;   //유저 이메일

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<BoardEntity> boardEntityList = new ArrayList<>();   //BoardEntity


}
