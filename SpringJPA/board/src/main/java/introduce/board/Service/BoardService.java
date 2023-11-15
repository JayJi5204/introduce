package introduce.board.Service;


import introduce.board.Entity.BoardEntity;
import introduce.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public Page<BoardEntity> findBoards(int pageNumber) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
        return boardRepository.findAll(pageable);
    }
}

