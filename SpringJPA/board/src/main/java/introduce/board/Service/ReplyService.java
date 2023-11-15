package introduce.board.Service;


import introduce.board.Entity.ReplyEntity;
import introduce.board.Repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public void saveReply(ReplyEntity replyEntity) {
        replyRepository.save(replyEntity);
    }

}
