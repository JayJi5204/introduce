package introduce.board.Service;

import introduce.board.DTO.ReplyDTO;
import introduce.board.Entity.BoardEntity;
import introduce.board.Entity.ReplyEntity;
import introduce.board.Repository.BoardRepository;
import introduce.board.Repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    public void saveReply(ReplyDTO replyDTO, Long boardId) {
        BoardEntity boardEntity = boardRepository.findById(boardId).orElseThrow();
        ReplyEntity replyEntity = new ReplyEntity(
                replyDTO.getId(),
                replyDTO.getReplyContent(),
                replyDTO.getReplyCreateAt(),
                boardEntity
        );
        replyRepository.save(replyEntity);
    }


    public List<ReplyEntity> getRepliesByBoardId(Long boardId) {
        return replyRepository.findByBoardEntity_BoardId(boardId);
    }
}