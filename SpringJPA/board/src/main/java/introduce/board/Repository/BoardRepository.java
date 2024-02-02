package introduce.board.Repository;

import introduce.board.Entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    //글 제목으로 검색
    Page<BoardEntity> findByTitleContaining(String keyword, Pageable pageable);

    //글 내용으로 검색
    Page<BoardEntity> findByContentContaining(String keyword, Pageable pageable);

}
