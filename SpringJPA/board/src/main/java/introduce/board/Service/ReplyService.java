package introduce.board.Service;


import introduce.board.DTO.ReplyDTO;
import introduce.board.Entity.BoardEntity;
import introduce.board.Entity.ReplyEntity;
import introduce.board.Repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReplyService {

    @Autowired
    private final ReplyRepository replyRepository;
    @Autowired
    private  BoardService boardService;

    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    public void saveReply(Long boardId, ReplyDTO replyForm) {
       Optional<BoardEntity> boardOptional  = boardService.getBoard(boardId);
        BoardEntity boardEntity = boardOptional.get();
        ReplyEntity replyEntity = replyForm.toEntity();
        replyEntity.setBoardEntity(boardEntity);
        replyRepository.save(replyEntity);
    }

    public Page<ReplyEntity> getReplyPage(Pageable pageable){
       return replyRepository.findAll(pageable);
    }

    public List<ReplyDTO> getRepliesByBoardId(Long boardId) {
        List<ReplyEntity> replyEntities = replyRepository.findByBoardEntity_Id(boardId);
        List<ReplyDTO> replyDTOs = replyEntities.stream()
                .map(ReplyDTO::replyForms)
                .collect(Collectors.toList());
        return replyDTOs;
    }


}
