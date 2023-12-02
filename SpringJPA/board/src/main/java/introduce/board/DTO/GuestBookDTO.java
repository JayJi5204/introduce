package introduce.board.DTO;

import introduce.board.Entity.GuestBookEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GuestBookDTO {

    private Long id;
    private String name;
    private String guestContent;
    private LocalDateTime guestCreateAt;

    protected GuestBookDTO(){

    }

    // 생성자를 이용하여 필수 필드 초기화
    public GuestBookDTO(Long id, String name, String guestContent, LocalDateTime guestTime){
        this.id=id;
        this.name=name;
        this.guestContent=guestContent;
        this.guestCreateAt=guestTime;
    }

    //DTO를 Entity로 변환
    public static GuestBookDTO fromGuestBook(GuestBookEntity guestBookEntity) {
        return new GuestBookDTO(
                guestBookEntity.getId(),
                guestBookEntity.getName(),
                guestBookEntity.getGuestContent(),
                guestBookEntity.getGuestCreateAt()
        );
    }
}
