package introduce.board.Controller;

import introduce.board.DTO.GuestBookDTO;
import introduce.board.Service.GuestBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final GuestBookService guestBookService;

    //메인페이지
    @GetMapping("/")
    public String getHomePage(Model model, Long id, String name, String guestContent, LocalDateTime guestCreateAt) {
        model.addAttribute("guestBookDTO", new GuestBookDTO(id,name,guestContent,guestCreateAt));
        return "HomePage";
    }

    // 수정된 코드: HomeController.java

    @PostMapping("/")
    public String postHomePage(@ModelAttribute @Valid GuestBookDTO guestBookDTO, Model model) {
        guestBookService.saveGuestBook(guestBookDTO);
        // 방명록이 작성되면 최근 방명록 작성자의 이름을 모델에 추가
        model.addAttribute("guestName", guestBookDTO.getName());

        return "redirect:/";
    }


    //정보페이지
    @RequestMapping("/inform")
    public String informPage() {
        return "Informpage";
    }

    //자기소개서 페이지
    @RequestMapping("/intro")
    public String introPage() {
        return "Intropage";
    }
    @GetMapping("/guestbook")
    public String guestPage(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable, Model model) {
        Page<GuestBookDTO> guestBookPage = guestBookService.getGuestBook(pageable);
        model.addAttribute("guestBookPage", guestBookPage);
        return "GuestPage";
    }
}
