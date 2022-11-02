package submissionTask;

import java.util.Scanner;

public class WordCounterRun {

    public static void main(String[] args) {

        //Declaring objects
        Scanner keyboard = new Scanner(System.in);
        WordCounterLogic wcl = new WordCounterLogic();

        //Declare variable
        String userInput = "";

        //Program startprompt
        System.out.printf("%n%s", "#    This program counts number of lines, words and characters you write.    #");
        System.out.printf("%n%s", "#               It will also find the longest word you wrote.                #");
        System.out.printf("%n%s", "# When done, write the word stop. (Line containing stop will not be counted) #");
        System.out.printf("%n%s%n", "#                  You can start writing on the line below.                  #");

        while (!wcl.checkStop(userInput)) {

            System.out.printf("%s", "#: ");

            userInput = keyboard.nextLine();

            if (!wcl.checkStop(userInput)) {

                wcl.countLines(userInput);
                wcl.countWords(userInput);
                wcl.countChars(userInput);
                wcl.findLongestWord(userInput);
            }

        }

        System.out.printf("%n%s%s%s", "You wrote ", wcl.getLines(), " lines of text.");
        System.out.printf("%n%s%s%s", "You wrote ", wcl.getWords(), " individual words.");
        System.out.printf("%n%s%s%s", "You wrote ", wcl.getCharacters(), " individual characters.");
        System.out.printf("%n%s%s%s", "The longest word you wrote is ", wcl.getLongestWord(), ".");

    }
}
