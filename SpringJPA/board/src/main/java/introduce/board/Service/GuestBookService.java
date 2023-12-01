package introduce.board.Service;

import introduce.board.DTO.GuestBookDTO;
import introduce.board.Entity.GuestBookEntity;
import introduce.board.Repository.BoardRepository;
import introduce.board.Repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;

    @Transactional
    public void saveGuestBook(GuestBookDTO guestBookDTO) {
        GuestBookEntity guestBookEntity = new GuestBookEntity(
                guestBookDTO.getName(),
                guestBookDTO.getGuestContent()
        );
        guestBookRepository.save(guestBookEntity);
    }

    @Transactional
    public Page<GuestBookDTO> getGuestBook(Pageable pageable) {
        Page<GuestBookEntity> guestBookEntityPage=guestBookRepository.findAll(pageable);
        return guestBookEntityPage.map(GuestBookDTO::fromGuestBook);
    }


}
