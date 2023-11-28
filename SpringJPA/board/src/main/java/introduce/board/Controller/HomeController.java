package introduce.board.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    @RequestMapping("/")
    public String homepage() {
        return "HomePage";
    }

    @RequestMapping("/inform")
    public String informpage() {
        return "Informpage";
    }

    @RequestMapping("/intro")
    public String intropage() {
        return "Intropage";
    }


}
