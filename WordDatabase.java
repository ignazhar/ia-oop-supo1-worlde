import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class WordDatabase {
    private static String[] wordleLa;
    private static String[] wordleTa;
    
    // Copilot's prompt: How to get parse the txt files and get arrays of words (used simpler version out of 2)
    public static String[] loadWordsSimple(String filePath) throws IOException {
        List<String> words = Files.readAllLines(Paths.get(filePath));
        return words.toArray(new String[0]);
    }

    // Asked google gemini pro to help with handling exceptions
    public WordDatabase() {
        try {
            wordleLa = loadWordsSimple("wordle-La.txt");
            wordleTa = loadWordsSimple("wordle-Ta.txt");
        } catch (IOException e) {
            System.err.println("Error loading words: " + e.getMessage());
            // Optional: Initialize arrays to empty to prevent null pointer errors later
            wordleLa = new String[0];
            wordleTa = new String[0];
        }
    }

    public static String chooseWord() {
        Random rng = new Random();
        return wordleLa[rng.nextInt(wordleLa.length)];
    }

    // debug method, TODO: delete
    public void printWords() {
        for (int i = 0; i < 10; i ++) {
            System.err.println(wordleLa[i]);
        }
    }
}
