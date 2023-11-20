package introduce.board.Service;


import introduce.board.Entity.BoardEntity;
import introduce.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;


    public BoardEntity saveBoard(BoardEntity boardEntity) {
        return boardRepository.save(boardEntity);
    }


    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }


    public Optional<BoardEntity> getBoard(Long id) {
        return boardRepository.findById(id);
    }

    public Page<BoardEntity> findBoards(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Page<BoardEntity> searchBoards(String option, String keyword, Pageable pageable) {
        if ("title".equals(option)) {
            return boardRepository.findByTitleContaining(keyword,pageable);
        } else {
            return boardRepository.findByContentContaining(keyword,pageable);
        }
    }


}

