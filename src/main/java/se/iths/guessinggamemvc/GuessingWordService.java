package se.iths.guessinggamemvc;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
//@SessionScope
public class GuessingWordService {


    List<String> words = new ArrayList<>(Arrays.asList("sun", "water", "tree", "zen", "giraffe", "boll", "unicorn", "coffee", "snow", "window", "lamp"));
    Random random = new Random();
    String secretWord;

    List<String> wordGuesses;

    public GuessingWordService() {
        init();
    }

    public void init() {
        secretWord = words.get(random.nextInt(words.size()));
        wordGuesses = new ArrayList<>();
    }

    public String makeWordGuess(String usersGuess) {

        if (!usersGuess.equals(secretWord)) {
            wordGuesses.add(usersGuess + " is not the right word, try again! " + secretWord);
        } else {
            wordGuesses.clear();
            init();
            return "Great job, you guessed the right word! Play again";
        }
        return "";
    }

    public List<String> getWordGuesses() {
        return wordGuesses;
    }

}
