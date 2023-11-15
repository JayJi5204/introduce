package introduce.board.Controller;

import introduce.board.Service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Slf4j
public class ReplyController {

    private ReplyService replyService;


}
