import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class WordDatabase {
    private static Set<String> wordleLa;
    private static Set<String> wordleTa;


    public static Set<String> loadFromResource(String resourceName) throws IOException {
        try (InputStream in = WordDatabase.class.getResourceAsStream("/" + resourceName)) {
            if (in == null) {
                throw new IOException("Resource not found: " + resourceName);
            }

            return new BufferedReader(new InputStreamReader(in))
                    .lines()
                    .collect(Collectors.toSet());
        }
    }


    public WordDatabase() {
        try {
            wordleLa = loadFromResource("wordle-La.txt");
            wordleTa = loadFromResource("wordle-Ta.txt");
        } catch (IOException e) {
            System.err.println("Error loading words: " + e.getMessage());
            wordleLa = new HashSet<>();
            wordleTa = new HashSet<>();
        }
    }

    public static String chooseWord() {
        Random rng = new Random();
        int index = rng.nextInt(wordleLa.size());
        return wordleLa.stream().skip(index).findFirst().orElse("");
    }

    public boolean isValid(String word) {
        return wordleLa.contains(word) || wordleTa.contains(word);
    }
}
