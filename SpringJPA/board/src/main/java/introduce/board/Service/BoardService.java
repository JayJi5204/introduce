package introduce.board.Service;


import introduce.board.DTO.BoardDTO;
import introduce.board.Entity.BoardEntity;
import introduce.board.Entity.ReplyEntity;
import introduce.board.Repository.BoardRepository;
import introduce.board.Repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;


    public void saveBoard(BoardDTO boardDTO) {
        List<ReplyEntity> replyEntity = replyRepository.findByBoardEntity_BoardId(boardDTO.getBoardId());
        BoardEntity boardEntity = new BoardEntity(
                boardDTO.getBoardId(),
                boardDTO.getTitle(),
                boardDTO.getContent(),
                boardDTO.getCreateAt(),
                boardDTO.getFixAt(),
                new ArrayList<>()
        );
        boardRepository.save(boardEntity);
    }

    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    public List<BoardEntity> getBoard() {
        return boardRepository.findAll();
    }

    public Page<BoardEntity> findBoards(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Page<BoardEntity> searchBoards(String option, String keyword, Pageable pageable) {
        Page<BoardEntity> boardEntities;
        if ("title".equals(option)) {
            boardEntities = boardRepository.findByTitleContaining(keyword, pageable);
        } else {
            boardEntities = boardRepository.findByContentContaining(keyword, pageable);
        }
        return boardEntities;
    }

    //API 설계를 위한 Service
//    public Optional<BoardEntity> findOne(Long id) {
//        return boardRepository.findById(id);
//    }
//
//    @Transactional
//    public void apiUpdate(Long id, String title) {
//        BoardEntity boardEntity = boardRepository.findById(id).get();
//        boardEntity.setTitle(title);
//    }
//
//    public List<BoardEntity> findBoard() {
//        return boardRepository.findAll();
//    }
}

