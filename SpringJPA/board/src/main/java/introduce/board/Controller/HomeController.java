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
    public String homepage(){
        log.info("HomePage");
        return "HomePage";
    }

    @RequestMapping("/inform")
    public String informpage(){
        log.info("InformPage");
        return "Informpage";
    }

    @RequestMapping("/intro")
    public String intropage(){
        log.info("IntroPage");
        return "Intropage";
    }

    @RequestMapping("/review")
    public String reviewpage(){
        log.info("ReviewPage");
        return "Reviewpage";
    }

//    @RequestMapping("/signunpage")
//    public String signinpage(){
//        log.info("SignUnPage");
//        return "SignUnPage";
//    }
}
