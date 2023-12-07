package introduce.board.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "guest_table")
public class GuestBookEntity {

    @Id
    @GeneratedValue
    @Column(name = "GuestBookEntity_Id")
    private Long id;    //방명록 번호

    private String name;    //방명록 방문자 이름

    private String guestContent;    //방명록 내용

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime guestCreateAt;    //방문 시간


    // 생성자를 이용하여 필수 필드 초기화
    public GuestBookEntity(String name,String guestContent){
        this.name=name;
        this.guestContent=guestContent;

    }
}
