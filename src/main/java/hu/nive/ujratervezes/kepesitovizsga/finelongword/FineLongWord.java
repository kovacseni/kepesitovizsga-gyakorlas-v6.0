package hu.nive.ujratervezes.kepesitovizsga.finelongword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FineLongWord {

    public char[] readFineLongWordFromFileAndGetItInAnArray(String filename) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(FineLongWord.class.getResourceAsStream("/" + filename)))) {
            int lengthOfWord = getLengthOfWord(filename);
            return getArray(br, lengthOfWord);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private int getLengthOfWord(String filename) throws IOException {
        List<String> contentOfFile = Files.readAllLines(Path.of("src/main/resources/" + filename));
        int horizontal = contentOfFile.get(0).length();
        int vertical = contentOfFile.size();

        return (horizontal + vertical - 1);
    }

    private char[] getArray(BufferedReader br, int lengthOfWord) throws IOException {
        char[] charsOfFineLongWord = new char[lengthOfWord];

        String firstLine = br.readLine();
        char[] charsOfLine = firstLine.toCharArray();
        int count = 0;
        for (char c : charsOfLine) {
            charsOfFineLongWord[count] = charsOfLine[count];
            count++;
        }
        loadOtherChars(br, charsOfFineLongWord, count);
        return charsOfFineLongWord;
    }

    private void loadOtherChars(BufferedReader br, char[] charsOfFineLongWord, int count) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            charsOfFineLongWord[count] = line.charAt(line.length() - 1);
            count++;
        }
    }
}
