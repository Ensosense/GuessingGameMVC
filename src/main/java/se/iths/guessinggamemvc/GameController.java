package se.iths.guessinggamemvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/guess")
    public String guessing(Model m){
    m.addAttribute("result");
    return "gamepage";
    }

    @PostMapping("/guess")
    public String guessingForm(@RequestParam int tal, Model m) {

        m.addAttribute("result", gameService.makeGuess(tal));
        m.addAttribute("guesses", gameService.getGuesses());
        return "gamepage";
    }
}
