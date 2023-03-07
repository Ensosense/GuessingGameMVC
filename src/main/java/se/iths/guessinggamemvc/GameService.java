package se.iths.guessinggamemvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameService {

    int secret;
    Random random = new Random();
    List<String> guesses;

    public GameService() {
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
