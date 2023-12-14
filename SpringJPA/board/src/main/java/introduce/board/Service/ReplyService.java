package introduce.board.Service;

import introduce.board.DTO.ReplyDTO;
import introduce.board.Entity.ReplyEntity;
import introduce.board.Repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final BoardService boardService;

    public void saveReply(Long boardId, ReplyDTO replyDTO) {
        ReplyEntity replyEntity = new ReplyEntity(
                replyDTO.getReplyContent(),
                replyDTO.getReplyCreateAt(),
                boardService.getBoard(boardId)
                        .orElseThrow(() -> new IllegalArgumentException("오류발생")).toEntity()
        );
        replyRepository.save(replyEntity);
    }

    public Long saveReply2(ReplyDTO replyDTO){



        return null;
    }


    public List<ReplyDTO> getRepliesByBoardId(Long boardId) {
        List<ReplyEntity> replyEntities = replyRepository.findByBoardEntity_Id(boardId);
        return replyEntities.stream()
                .map(ReplyDTO::toReplyDTO)
                .collect(Collectors.toList());
    }
}