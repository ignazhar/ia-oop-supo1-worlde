import java.util.Scanner;

public class WordInput {
    private Scanner in;

    public WordInput() {
        this.in = new Scanner(System.in);  
    }

    public String readWord(WordDatabase database) {
        String word = in.nextLine();

        word = word.toLowerCase();

        // checking validity of the word
        if (word.length() != 5) {
            throw new IllegalArgumentException("The length of the word must be 5 letters");
        }
        
        if (!database.isValid(word)) {
            throw new IllegalArgumentException("Word not found in the database");
        }
        
        return word;
    }

    public void close() {
        in.close();
    }
}
