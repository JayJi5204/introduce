package introduce.board.Service;

import introduce.board.DTO.GuestBookDTO;
import introduce.board.Entity.GuestBookEntity;
import introduce.board.Repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;

    public void saveGuestBook(GuestBookDTO guestBookDTO) {
        GuestBookEntity guestBookEntity = new GuestBookEntity(guestBookDTO.getName(), guestBookDTO.getGuestContent());
        guestBookRepository.save(guestBookEntity);
    }


    public Page<GuestBookDTO> getGuestBook(Pageable pageable) {
        Page<GuestBookEntity> guestBookEntityPage = guestBookRepository.findAll(pageable);
        return guestBookEntityPage.map(GuestBookDTO::toGuestBookDTO);
    }

    //API 설계를 위한 Service
    public Long saveGuest(GuestBookDTO guestBookDTO) {
        GuestBookEntity guestBookEntity = new GuestBookEntity(guestBookDTO.getName(), guestBookDTO.getGuestContent());
        guestBookRepository.save(guestBookEntity);
        return guestBookEntity.getId();
    }

    public List<GuestBookEntity> findGuest() {
        return guestBookRepository.findAll();

    }


}
