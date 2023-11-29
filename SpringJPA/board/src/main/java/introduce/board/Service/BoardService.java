package introduce.board.Service;


import introduce.board.DTO.BoardDTO;
import introduce.board.Entity.BoardEntity;
import introduce.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    // Entity를 DTO로 변환해서 저장
    public BoardDTO saveBoard(BoardDTO boardDTO) {
        BoardEntity boardEntity = boardDTO.toEntity();
        boardRepository.save(boardEntity);
        return boardDTO;
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    // Entity를 DTO로 변환해서 반환
    public Optional<BoardDTO> getBoard(Long id) {
        Optional<BoardEntity> boardEntity = boardRepository.findById(id);
        return boardEntity.map(BoardDTO::boardForms);
    }

    // Page<BoardEntity>를 Page<BoardDTO>로 변환해서 반환
    public Page<BoardDTO> findBoards(Pageable pageable) {
        Page<BoardEntity> boardEntities = boardRepository.findAll(pageable);
        return boardEntities.map(BoardDTO::boardForms);
    }

    // Page<BoardEntity>를 Page<BoardDTO>로 변환해서 반환
    public Page<BoardDTO> searchBoards(String option, String keyword, Pageable pageable) {
        Page<BoardEntity> boardEntities;
        if ("title".equals(option)) {
            boardEntities = boardRepository.findByTitleContaining(keyword, pageable);
        } else {
            boardEntities = boardRepository.findByContentContaining(keyword, pageable);
        }
        return boardEntities.map(BoardDTO::boardForms);
    }


}

