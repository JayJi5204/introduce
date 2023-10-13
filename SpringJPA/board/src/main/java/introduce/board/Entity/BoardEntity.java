package introduce.board.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class BoardEntity {
    @Id
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;

}
