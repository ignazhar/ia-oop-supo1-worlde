public class WordleGame {
    private static int guessNumber = 0;
    private static final int guessLimit = 6;
    
    public static void main(String[] args) {
        WordDatabase database = new WordDatabase();

        String targetWord = WordDatabase.chooseWord(); 

        WordInput input = new WordInput();

        while (guessNumber < guessLimit) {
            guessNumber ++;
            System.out.println("Enter word: (" + guessNumber + " out of " + guessLimit + "):");
            try {
                String guessWord = input.readWord(database);
                 
                String result = WordHandler.compare(guessWord, targetWord);

                System.out.println(result);

                if (result.equals("+++++")) {
                    System.out.println("Won game in " + guessNumber + " guesses !!!");
                    return;
                }
            } catch (IllegalArgumentException s) {
                System.out.println("Word input error: " + s.getMessage());
                // giving another attempt
                guessNumber --;
                continue;
            }
        }

        System.out.println("Couldn't guess the word! The answer was " + targetWord);

        input.close();
    }
}
