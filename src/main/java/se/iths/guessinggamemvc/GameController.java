package se.iths.guessinggamemvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class GameController {

    //istället för att skriva new GuessingNumberService
    @Autowired
    private GuessingNumberService guessingNumberService;

    @Autowired
    private GuessingWordService guessingWordService;

    @Autowired
    private UserService userService;

    @Autowired
    private User user;


    @GetMapping("/user")
    public String user() {
        return "user";
    }

   @PostMapping("/user")
   public String welcomeUser(@RequestParam String username, Model model) {
       model.addAttribute("welcome", userService.welcomeUser(username));
       model.addAttribute("users", userService.getUsers());
       //skickas till sidan choiceOfGame där jag kan displaya "welcome" och "users"
       return "choiceOfGame";
   }

    @GetMapping("/choice")
    public String choice() {
        return "choiceOfGame";
    }
    @PostMapping("/choice")
    public RedirectView choiceForm(@RequestParam("choice") String choice) {
        if (choice.equals("word")) {
            return new RedirectView("/wordguess");
        } else {
            return new RedirectView("/guess");
        }

    }



    @GetMapping("/guess")
    public String guessNumber() {
        return "numbergamepage";
    }

    @PostMapping("/guess")
    public String guessNumberForm(@RequestParam int tal, Model m) {
        m.addAttribute("result", guessingNumberService.makeGuess(tal));
        m.addAttribute("guesses", guessingNumberService.getGuesses());
        return "numbergamepage";
    }


    @GetMapping("/wordguess")
    public String guessWord() {
        return "wordgamepage";
    }

    @PostMapping("/wordguess")
    public String guessWordForm(@RequestParam String word, Model m) {
        m.addAttribute("wordresult", guessingWordService.makeWordGuess(word));
        m.addAttribute("wordguesses", guessingWordService.getWordGuesses());
        return "wordgamepage";
    }
}
