package introduce.board.API;

import introduce.board.Service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReplyAPI {

    private final ReplyService replyService;


    @PostMapping("/api/board/{id}/reply")
    public test test(){
        return null;
    }

    @Data
    @AllArgsConstructor
    static class test{

    }
}
