package se.iths.guessinggamemvc;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@SessionScope
public class GuessingNumberService {

    int secret;
    Random random = new Random();
    List<String> guesses;

    public GuessingNumberService() {
        init();
    }

    public void init() {
        secret = random.nextInt(1, 11);
        guesses = new ArrayList<>();
    }

    public String makeGuess(int guess) {

        if (secret > guess) {
            guesses.add(guess + " is too small");
        } else if (secret < guess) {
            guesses.add(guess + " is too big");
        } else {
            init();
            return  "Correct, new game!";
        }
        return "";
    }

    public List<String> getGuesses(){
        return guesses;
    }

}
