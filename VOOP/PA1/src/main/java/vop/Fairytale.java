package vop;

import lib.GenericFairytale;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fairytale  implements Comparable<Fairytale> {

    private String contents = "";
    private int words;
    private int longestWordLength;

    public Fairytale(File file, boolean isReversed) throws FileNotFoundException, NotAFairytaleException {
        loadFairytale(file, isReversed);
    }

    public Fairytale(String content, boolean isReversed) {
        if (isReversed){
            contents = reverseString(content);
        } else{
            contents = content;
        }
    }

    private void loadFairytale(File fairytale, boolean reverse) throws NotAFairytaleException, FileNotFoundException {
        String[] split = fairytale.getName().split("\\.");
        if (!split[1].equals("fairytale")) throw new NotAFairytaleException();
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(fairytale);
        } catch (FileNotFoundException e){
            System.out.println("There is no file");
        }

        if (reverse){
            while (inputStream.hasNextLine()){
                contents = contents + reverseString(inputStream.nextLine()) + "\n";
            }
        }else {
            while (inputStream.hasNextLine()){
                contents = contents + inputStream.nextLine() + "\n";
            }
        }
        inputStream.close();
    }

    public void analyze() {
        countWords();
        computeLongestWordLength();
    }

    private void countWords() {
        char[] content = contents.toCharArray();
        int count = 1;
        for (char c: content) {
            if (c == ' '){
                count++;
            }
        }
        words = count;
    }

    private void computeLongestWordLength() {
        longestWordLength = 0;
        String[] split = contents.split(" ");
        for (String s: split) {
            if (s.toCharArray().length > longestWordLength){
                longestWordLength = s.length();
            }
        }
    }
    public static String reverseString(String input) {
        StringBuilder output = new StringBuilder(input);
        output = output.reverse();
        input = output.toString();
        return input.trim();
    }

    public String getContents() {
        return contents;
    }

    public int getLongestWordLength() {
        return longestWordLength;
    }

    public int getWords() {
        return words;
    }


    @Override
    public int compareTo(Fairytale o) {
        if (getLongestWordLength() < o.getLongestWordLength()){
            return 1;
        } else if (getLongestWordLength() > o.getLongestWordLength()) {
            return -1;
        } else{
            return 0;
        }
    }
}
