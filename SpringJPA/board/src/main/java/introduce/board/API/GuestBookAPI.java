package introduce.board.API;

import introduce.board.DTO.GuestBookDTO;
import introduce.board.Entity.GuestBookEntity;
import introduce.board.Service.GuestBookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GuestBookAPI {

    private final GuestBookService guestBookService;

    //방명록 작성 API
    @PostMapping("/api/")
    public CreateGuestResponse saveGuest(@RequestBody @Valid CreateGuestRequest request) {
        GuestBookDTO guestBookDTO = new GuestBookDTO(null, request.name, request.guestContent, null);
        Long id = guestBookService.saveGuest(guestBookDTO);
        return new CreateGuestResponse(id);
    }

    // 방명록 조회 API
    @GetMapping("/api/guestbook")
    public Result<List<GuestDTO>> guest() {
        List<GuestBookEntity> findGuest = guestBookService.findGuest();
        List<GuestDTO> guestList = findGuest.stream()
                .map(guestBookEntity -> new GuestDTO(guestBookEntity.getName(), guestBookEntity.getGuestContent()))
                .collect(Collectors.toList());
        return new Result<>(guestList);
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
        private String guestContent;
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class GuestDTO {
        private String name;
        private String guestContent;
    }

}
