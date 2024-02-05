package introduce.board.DTO;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GuestBookDTO {

    private Long id;
    private String name;
    private String guestContent;
    private LocalDateTime guestCreateAt;

    public GuestBookDTO(Long id, String name, String guestContent, LocalDateTime guestTime) {
        this.id = id;
        this.name = name;
        this.guestContent = guestContent;
        this.guestCreateAt = guestTime;
    }

}
