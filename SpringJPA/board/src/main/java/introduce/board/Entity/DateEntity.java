package introduce.board.Entity;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class DateEntity {

    private LocalDateTime createAt; //작성일
    private LocalDateTime fixAt;    //수정일
}
