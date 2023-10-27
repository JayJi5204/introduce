package introduce.board.Service;


import introduce.board.Entity.BoardEntity;
import introduce.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;


    public void saveBoard(BoardEntity boardEntity){
        boardRepository.save(boardEntity);
    }
    public List<BoardEntity> findBoard(){
        return boardRepository.findAll();
    }
    public void deleteBoard(BoardEntity boardEntity){
        boardRepository.delete(boardEntity);
    }

}
