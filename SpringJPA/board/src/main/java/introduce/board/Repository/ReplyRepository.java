package introduce.board.Repository;

import introduce.board.Entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

    //게시판 글 번호 조회로 댓글 리스트화
    List<ReplyEntity> findByBoardEntity_BoardId(Long boardId);

    Optional<ReplyEntity> findById(Long id);


}
