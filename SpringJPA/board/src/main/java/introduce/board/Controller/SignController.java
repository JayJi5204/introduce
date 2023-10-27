package introduce.board.Controller;

import introduce.board.Entity.BoardEntity;
import introduce.board.Entity.UserEntity;
import introduce.board.Form.SignUpForm;
import introduce.board.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SignController {

    private final UserService userService;

    @GetMapping("/signup")
    public String GetSignup(Model model) {
        log.info("SignUpPage");
        model.addAttribute("signUpForm", new SignUpForm());
        return "SignUpPage";
    }
    @PostMapping("/signup")
    public String PostSignUp(@Valid SignUpForm signUpForm) {
        UserEntity userEntity=new UserEntity();
        userEntity.setUserName(signUpForm.getUserName());
        userEntity.setUserEmail(signUpForm.getUserEmail());
        userService.saveUser(userEntity);
        return "redirect:/";
    }
    /**@GetMapping("/")
    public String SignIn(Model model) {
        log.info("BoardPage");
        List<UserEntity> userEntities=userService.findUser();
        model.addAttribute("userEntities",userEntities);
        return "BoardPage";
    }**/
}
