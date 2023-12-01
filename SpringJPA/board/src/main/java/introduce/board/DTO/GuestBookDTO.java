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
    private LocalDateTime guestTime;

    public GuestBookDTO(Long id, String name, String guestContent, LocalDateTime guestTime){
        this.id=id;
        this.name=name;
        this.guestContent=guestContent;
        this.guestTime=guestTime;
    }

    public static GuestBookDTO fromGuestBook(GuestBookEntity guestBookEntity) {
        return new GuestBookDTO(
                guestBookEntity.getId(),
                guestBookEntity.getName(),
                guestBookEntity.getGuestContent(),
                guestBookEntity.getGuestTime()
        );
    }
}
