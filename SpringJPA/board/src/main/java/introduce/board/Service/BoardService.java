package introduce.board.Service;


import introduce.board.Entity.BoardEntity;
import introduce.board.Form.BoardForm;
import introduce.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<BoardEntity> findBoard(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return boardRepository.findAll(sort);
    }
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }


    public Optional<BoardEntity> getBoard(Long id){
       return boardRepository.findById(id);
    }




    }

