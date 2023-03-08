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


    @PostMapping("/choice")
    public RedirectView handleSubmit(@RequestParam("choice") String choice) {
        if (choice.equals("word")) {
            return new RedirectView("/wordguess");
        } else {
            return new RedirectView("/guess");
        }
    }

    @GetMapping("/guess")
    public String guessing(Model m) {
        m.addAttribute("result");
        return "numbergamepage";
    }

    @PostMapping("/guess")
    public String guessingForm(@RequestParam int tal, Model m) {
        m.addAttribute("result", guessingNumberService.makeGuess(tal));
        m.addAttribute("guesses", guessingNumberService.getGuesses());
        return "numbergamepage";
    }


    @GetMapping("/wordguess")
    public String guessingWord(Model m) {
        m.addAttribute("result");
        return "wordgamepage";
    }
    @PostMapping("/wordguess")
    public String guessWordForm(@RequestParam String word, Model m) {
        m.addAttribute("wordresult", guessingWordService.makeWordGuess(word));
        m.addAttribute("wordguesses", guessingWordService.getWordGuesses());
        return "wordgamepage";
    }
}
