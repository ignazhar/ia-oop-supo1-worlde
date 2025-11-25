import java.util.Scanner;

public class WordInput {
    public String readWord(WordDatabase database) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        in.close();

        word = word.toLowerCase();

        // checking validity of the word
        if (word.length() != 5) {
            throw new IllegalArgumentException("The length of the word must be 5 letters");
        }
        
        if (!database.isValid(word)) {
            throw new IllegalArgumentException("Invalid word (not found in the database)");
        }
        
        return word;
    }
}
