package introduce.board.Service;


import introduce.board.DTO.BoardDTO;
import introduce.board.Entity.BoardEntity;
import introduce.board.Repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;


    public void saveBoard(BoardDTO boardDTO) {
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

    public Optional<BoardEntity> getBoard(Long boardId) {
        return boardRepository.findById(boardId);
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
    public Long saveBoardApi(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity(boardDTO.getBoardId(), boardDTO.getTitle(), boardDTO.getContent(), boardDTO.getCreateAt(), boardDTO.getFixAt(), boardDTO.getReplyEntity());
        boardRepository.save(boardEntity);
        return boardEntity.getBoardId();
    }

    @Transactional
    public void updateBoardApi(Long boardId, String title, String content) {
        BoardEntity boardEntity = boardRepository.findById(boardId).orElseThrow();
        boardEntity.updateFields(title, content);

    }

    public List<BoardEntity> findBoardApi() {
        return boardRepository.findAll();
    }
}

