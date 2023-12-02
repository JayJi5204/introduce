package introduce.board.Controller;

import introduce.board.DTO.GuestBookDTO;
import introduce.board.Service.GuestBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public String getHomePage(Pageable pageable, Model model, Long id, String name, String guestContent, LocalDateTime guestCreatAt) {
        Page<GuestBookDTO> guestBookPage = guestBookService.getGuestBook(pageable);
        model.addAttribute("guestBookDTO", new GuestBookDTO(id,name,guestContent,guestCreatAt));
        model.addAttribute("guestBookPage", guestBookPage);
        return "HomePage";
    }

    @PostMapping("/guestBook")
    public String postHomePage(@ModelAttribute @Valid GuestBookDTO guestBookDTO) {
        guestBookService.saveGuestBook(guestBookDTO);
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
}
