package introduce.board.API;

import introduce.board.DTO.GuestBookDTO;
import introduce.board.Service.GuestBookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GuestBookAPI {

    private final GuestBookService guestBookService;


    @PostMapping("/api/t")
    public CreateGuestResponse saveGuest(@RequestBody @Valid CreateGuestRequest request) {
        GuestBookDTO guestBookDTO = new GuestBookDTO(null, request.name, request.replyContent, null);
        Long id = guestBookService.saveGuest(guestBookDTO);
        return new CreateGuestResponse(id);
    }

    @Data
    @AllArgsConstructor
    static class CreateGuestResponse {
        private Long id;
    }

    @Data
    @AllArgsConstructor
    static class CreateGuestRequest {
        private String name;
        private String replyContent;
    }
}
