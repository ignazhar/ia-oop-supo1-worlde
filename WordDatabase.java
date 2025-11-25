import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class WordDatabase {
    private static String[] wordleLa;
    private static String[] wordleTa;
    
    // [AI] Copilot's prompt: How to get parse the txt files and get arrays of words (used simpler version out of 2)
    public static String[] loadFromFile(String filePath) throws IOException {
        List<String> words = Files.readAllLines(Paths.get(filePath));
        return words.toArray(new String[0]);
    }

    // [AI] Asked google gemini pro to help with handling exceptions
    public WordDatabase() {
        try {
            wordleLa = loadFromFile("wordle-La.txt");
            wordleTa = loadFromFile("wordle-Ta.txt");
        } catch (IOException e) {
            System.err.println("Error loading words: " + e.getMessage());
            // Initialize arrays to empty to prevent null pointer errors later
            wordleLa = new String[0];
            wordleTa = new String[0];
        }
    }

    public static String chooseWord() {
        Random rng = new Random();
        return wordleLa[rng.nextInt(wordleLa.length)];
    }

    private boolean isIn(String[] list, String word) {
        int low = 0, high = list.length - 1;
        // binary search to check isIn in O(logn) since they are sorted
        while (low < high) {
            int mid = low + (high - low) / 2;
            // [Question: for some reason A == B didn't work properly while A.equals(B) works ...]
            if (list[mid].equals(word))
                return true;
            else if (list[mid].compareTo(word) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return list[low].equals(word);
    }

    public boolean isValid(String word) {
        return isIn(wordleLa, word) || isIn(wordleTa, word);
    }
}
