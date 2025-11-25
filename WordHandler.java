public class WordHandler {
    private static int getIndex(char c) {
        return Character.getNumericValue(c) - Character.getNumericValue('a');
    }

    public static String compare(String word, String target) {
        System.out.println("Try: " + word + " to " + target);

        int n = word.length();

        char[] result = new char[n];
    
        int[] countChars = new int[26];

        // setting '+'
        for (int i = 0; i < n; i ++) {
            System.out.println(word.charAt(i) + " vs " + target.charAt(i));
            if (word.charAt(i) == target.charAt(i)) {
                result[i] = '+';
            }
            else {
                result[i] = '-';
                countChars[getIndex(target.charAt(i))] ++;
            }
        }

        // setting '-' and '?'
        for (int i = 0; i < n; i ++) {
            if (result[i] == '+') {
                continue;
            }
            int charIndex = getIndex(word.charAt(i));
            if (countChars[charIndex] == 0) {
                result[i] = '-';
            }
            else {
                result[i] = '?';
                countChars[charIndex] --;
            }
        }

        return String.valueOf(result);
    }    
}
