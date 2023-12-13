package introduce.board.Service;


import introduce.board.DTO.BoardDTO;
import introduce.board.Entity.BoardEntity;
import introduce.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    // Entity를 DTO로 변환해서 저장
    public Long saveBoard(BoardDTO boardDTO) {
        BoardEntity boardEntity = boardDTO.toEntity();
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        return savedEntity.getId();
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    // Entity를 DTO로 변환해서 반환
    public Optional<BoardDTO> getBoard(Long id) {
        Optional<BoardEntity> boardEntity = boardRepository.findById(id);
        return boardEntity.map(BoardDTO::toBoardEntity);
    }

    // Page<BoardEntity>를 Page<BoardDTO>로 변환해서 반환
    public Page<BoardDTO> findBoards(Pageable pageable) {
        Page<BoardEntity> boardEntities = boardRepository.findAll(pageable);
        return boardEntities.map(BoardDTO::toBoardEntity);
    }

    // Page<BoardEntity>를 Page<BoardDTO>로 변환해서 반환
    public Page<BoardDTO> searchBoards(String option, String keyword, Pageable pageable) {
        Page<BoardEntity> boardEntities;
        if ("title".equals(option)) {
            boardEntities = boardRepository.findByTitleContaining(keyword, pageable);
        } else {
            boardEntities = boardRepository.findByContentContaining(keyword, pageable);
        }
        return boardEntities.map(BoardDTO::toBoardEntity);
    }

    //API 설계를 위한 Service
    public Optional<BoardEntity> findOne(Long id) {
        return boardRepository.findById(id);
    }

    @Transactional
    public void apiUpdate(Long id, String title) {
        BoardEntity boardEntity = boardRepository.findById(id).get();
        boardEntity.setTitle(title);
    }

    public List<BoardEntity> findBoard() {
        return boardRepository.findAll();
    }
}

