package submissionTask;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTests {

    @Test
    public void testNumberOfWords() {
        //Arrange
        WordCounterLogic wcl = new WordCounterLogic();

        String userInput = "four words for testing";

        wcl.countWords(userInput);

        int expected = 4;

        //Act
        int actual = wcl.getWords();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testNumberOfWordsWeirdSpacing() {
        //Arrange
        WordCounterLogic wcl = new WordCounterLogic();

        String userInput = "Six  words   for    testing weird spacing";

        wcl.countWords(userInput);

        int expected = 6;

        //Act
        int actual = wcl.getWords();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testNumberOfLines() {
        //Arrange
        WordCounterLogic wcl = new WordCounterLogic();

        String userInput = "";

        for (int i = 0; i < 5; i++) {
            userInput = "lines for testing";
            wcl.countLines(userInput);
        }

        int expected = 5;

        //Act
        int actual = wcl.getLines();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestWord() {
        //Arrange
        WordCounterLogic wcl = new WordCounterLogic();

        String userInput = "This is the first line, testing more than one line.";

        wcl.findLongestWord(userInput);

        userInput = "The longest word in our two lines is hippopotamus";

        wcl.findLongestWord(userInput);

        String expected = "hippopotamus";

        //Act
        String actual = wcl.getLongestWord();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestWordBoundary() {
        //Arrange
        WordCounterLogic wcl = new WordCounterLogic();

        String userInput = "Earthbound should not be the longest word";

        wcl.findLongestWord(userInput);

        userInput = "Neither should fabrication be the longest word";

        wcl.findLongestWord(userInput);

        userInput = "The longest word in our lines should be hippopotamus";

        wcl.findLongestWord(userInput);

        String expected = "hippopotamus";

        //Act
        String actual = wcl.getLongestWord();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestWordFirstLine() {
        //Arrange
        WordCounterLogic wcl = new WordCounterLogic();

        String userInput = "The longest word in our two lines is hippopotamus ";

        wcl.findLongestWord(userInput);

        userInput = "but this time it's in the first line";

        wcl.findLongestWord(userInput);

        String expected = "hippopotamus";

        //Act
        String actual = wcl.getLongestWord();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestWordOneWord() {
        //Arrange
        WordCounterLogic wcl = new WordCounterLogic();

        String userInput = "hippopotamus ";

        wcl.findLongestWord(userInput);

        userInput = "cheese";

        wcl.findLongestWord(userInput);

        String expected = "hippopotamus";

        //Act
        String actual = wcl.getLongestWord();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testNumberOfCharacters() {
        //Arrange
        WordCounterLogic wcl = new WordCounterLogic();

        String userInput = "In this test we test the total number of characters";

        wcl.countChars(userInput);

        userInput = "over two lines of text the total includes spaces, periods etc.";

        wcl.countChars(userInput);

        int expected = 113;

        //Act
        int actual = wcl.getCharacters();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testNumberOfCharactersShortLines() {
        //Arrange
        WordCounterLogic wcl = new WordCounterLogic();

        String userInput = "one";

        wcl.countChars(userInput);

        userInput = "two";

        wcl.countChars(userInput);

        int expected = 6;

        //Act
        int actual = wcl.getCharacters();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopLineTrue() {
        //Arrange
        WordCounterLogic wcl = new WordCounterLogic();

        String userInput = "banana stop fish";

        boolean expected = true;

        //Act
        boolean actual = wcl.checkStop(userInput);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testStopLineFalse() {
        //Arrange
        WordCounterLogic wcl = new WordCounterLogic();

        String userInput = "banana fish potato";

        boolean expected = false;

        //Act
        boolean actual = wcl.checkStop(userInput);

        //Assert
        assertEquals(expected, actual);
    }
}
