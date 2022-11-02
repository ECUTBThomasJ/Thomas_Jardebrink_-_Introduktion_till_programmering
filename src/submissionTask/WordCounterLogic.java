package submissionTask;

/**
 * Logic class for word counter program
 *
 * @Attr lines, words, chars and longestWord.
 */

public class WordCounterLogic {

    private int lines, words, chars;    //Attributes

    private String longestWord = "";

    /*
     * Method counts number of lines
     * @param input - one user entered line.
     */
    public void countLines(String input) {
        lines++;
    }

    /*
     * Method counts number of words
     * @param input - one user entered line.
     */
    public void countWords(String input) {

        for (int j = 0; j < input.length(); j++) {
            if (((j != 0) && (input.charAt(j) == ' ') && (input.charAt(j - 1) != ' ')) || (j == (input.length() - 1))) {
                words++;
            }
        }
    }

    /*
     * Method counts number of characters
     * @param input - one user entered line.
     */
    public void countChars(String input) {

        for (int i = 0; i < input.length(); i++) {
            chars++;
        }

    }

    /*
     * Method finds the longest word in a single line.
     * Compares to the longest previous word.
     * Sets the new longest word over all.
     * @param input - one user entered line.
     */
    public void findLongestWord(String input) {
        String currentLongest = longestWord;

        //Method variables to handle finding the longest word
        int startOfWord = 0, endOfWord = 0, lengthOfWord = 0, previousWordLength = 0;

        //Section removes spaces at beginning and end of line
        if (input.charAt(0) == ' ') {
            input = input.replaceFirst(" ", "");
        }

        if (input.charAt(input.length() - 1) == ' ') {

            input = input.substring(0, input.length() - 1);
        }

        // Section finds and compares words to find the longest word.
        if (input.contains(" ")) { //if there are more than one word in the line.

            for (int i = 0; i < input.length(); i++) {

                if ((i != 0) && (input.charAt(i) == ' ') && (input.charAt(i - 1) != ' ') || (i == (input.length() - 1))) {

                    startOfWord = endOfWord;
                    endOfWord = i;
                    lengthOfWord = endOfWord - startOfWord;

                    if (lengthOfWord > previousWordLength) {
                        previousWordLength = lengthOfWord;
                        if (currentLongest.length() < previousWordLength) {
                            currentLongest = "";

                            if ((startOfWord > 1) && (i < (input.length() - 1))) {
                                for (int j = startOfWord; j < endOfWord - 1; j++) {
                                    currentLongest += input.charAt(j + 1);
                                }
                            } else if ((startOfWord > 1) && (i == (input.length() - 1))) {
                                for (int j = startOfWord; j < endOfWord; j++) {
                                    currentLongest += input.charAt(j + 1);
                                }
                            } else {
                                for (int j = startOfWord; j < previousWordLength; j++) {
                                    currentLongest += input.charAt(j);
                                }
                            }
                        }
                    }
                }
            }

        } else {  //If there is only one word (No spaces)
            for (int i = 0; i < input.length(); i++) {

                if (((input.charAt(i) == ' ') && (input.charAt(i - 1) != ' ')) || (i == (input.length() - 1))) {

                    startOfWord = endOfWord;
                    endOfWord = (i + 1);
                    lengthOfWord = endOfWord - startOfWord;

                    if (lengthOfWord > previousWordLength) {
                        previousWordLength = lengthOfWord;
                        if (currentLongest.length() < previousWordLength) {
                            currentLongest = "";

                            if ((startOfWord > 1) && (i < (input.length() - 1))) {
                                for (int j = startOfWord; j < endOfWord - 1; j++) {
                                    currentLongest += input.charAt(j + 1);
                                }
                            } else if ((startOfWord > 1) && (i == (input.length() - 1))) {
                                for (int j = startOfWord; j < endOfWord; j++) {
                                    currentLongest += input.charAt(j + 1);
                                }
                            } else {
                                for (int j = startOfWord; j < previousWordLength; j++) {
                                    currentLongest += input.charAt(j);
                                }
                            }
                        }
                    }
                }
            }
        }
        longestWord = currentLongest;
    }

    /*
     * Method returns number of lines
     */
    public int getLines() {
        return lines;
    }

    /*
     * Method returns number of words
     */
    public int getWords() {
        return words;
    }

    /*
     * Method returns the longest word over all lines
     */
    public String getLongestWord() {
        return longestWord;
    }

    /*
     * Method returns number of characters
     */
    public int getCharacters() {
        return chars;
    }

    /*
     * Method checks if line contains the word stop.
     */
    public boolean checkStop(String input) {

        boolean containsStop = false;

        if (input.toLowerCase().contains("stop")) {
            containsStop = true;
        }

        return containsStop;
    }
}
