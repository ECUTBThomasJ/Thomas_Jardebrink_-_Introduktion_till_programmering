package submissionTask;

public class WordCounterLogic {

    private int lines, words, chars;    //Attributes

    private String longestWord = "";

    public void countLines(String input) {
        lines++;
    }

    public void countWords(String input) {

        for (int j = 0; j < input.length(); j++) {
            if (((j != 0) && (input.charAt(j) == ' ') && (input.charAt(j - 1) != ' ')) || (j == (input.length() - 1))) {
                words++;
            }
        }
    }

    public void countChars(String input) {

        for (int i = 0; i < input.length(); i++) {
            chars++;
        }

    }

    public void findLongestWord(String input) {
        String currentLongest = longestWord;

        //Method variables to handle finding the longest word
        int a = 0, b = 0, c = 0, d = 0;

        if (input.charAt(0) == ' ') {
            input = input.replaceFirst(" ", "");
        }

        if (input.charAt(input.length() - 1) == ' ') {

            input = input.substring(0, input.length() - 1);
        }


        if (input.contains(" ")) {

            for (int i = 0; i < input.length(); i++) {

                if ((i != 0) && (input.charAt(i) == ' ') && (input.charAt(i - 1) != ' ') || (i == (input.length() - 1))) {

                    a = b;
                    b = i;
                    c = b - a;

                    if (c > d) {
                        d = c;
                        if (currentLongest.length() < d) {
                            currentLongest = "";

                            if ((a > 1) && (i < (input.length() - 1))) {
                                for (int j = a; j < b - 1; j++) {
                                    currentLongest += input.charAt(j + 1);
                                }
                            } else if ((a > 1) && (i == (input.length() - 1))) {
                                for (int j = a; j < b; j++) {
                                    currentLongest += input.charAt(j + 1);
                                }
                            } else {
                                for (int j = a; j < d; j++) {
                                    currentLongest += input.charAt(j);
                                }
                            }


                        }
                    }
                }

            }

        } else {
            for (int i = 0; i < input.length(); i++) {

                if (((input.charAt(i) == ' ') && (input.charAt(i - 1) != ' ')) || (i == (input.length() - 1))) {

                    a = b;
                    b = (i + 1);
                    c = b - a;

                    if (c > d) {
                        d = c;
                        if (currentLongest.length() < d) {
                            currentLongest = "";

                            if ((a > 1) && (i < (input.length() - 1))) {
                                for (int j = a; j < b - 1; j++) {
                                    currentLongest += input.charAt(j + 1);
                                }
                            } else if ((a > 1) && (i == (input.length() - 1))) {
                                for (int j = a; j < b; j++) {
                                    currentLongest += input.charAt(j + 1);
                                }
                            } else {
                                for (int j = a; j < d; j++) {
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

    public int getLines() {
        return lines;
    }

    public int getWords() {
        return words;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public int getCharacters() {
        return chars;
    }

    public boolean checkStop(String input) {

        boolean containsStop = false;

        if (input.toLowerCase().contains("stop")) {
            containsStop = true;
        }

        return containsStop;
    }
}
