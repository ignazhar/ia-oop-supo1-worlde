public class WordleGame {
    private static int guessNumber = 0;
    private static final int guessLimit = 10;
    
    public static void main(String[] args) {
        WordDatabase database = new WordDatabase();
        // database.printWords();

        String targetWord = database.chooseWord(); 

        System.out.println(targetWord);

        // while (guessNumber < guessLimit) {
        //     String guessWord = try { readWord() } catch 
        // }
    }
}
