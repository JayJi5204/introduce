package introduce.board.DTO;

import introduce.board.Entity.ReplyEntity;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {

    private Long id;
    private String replyContent;
    private LocalDateTime createAt;
    private LocalDateTime fixAt;
}
