package introduce.board.Repository;

import introduce.board.Entity.ReplyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity,Long> {

    //게시판 글 번호 조회로 댓글 리스트화
    List<ReplyEntity> findByBoardEntity_Id(Long boardId);
}
