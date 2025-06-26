import java.io.*;
import java.util.*;

public class Main {
    static HashSet<String> uniqueSubstrings = new HashSet<>();

    public static void main(String[] args) throws IOException { 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        generateSubstrings(input);
        System.out.println(uniqueSubstrings.size());
    }

    public static void generateSubstrings(String word) {
        int length = word.length();
        for (int start = 0; start < length; start++) {
            for (int end = start + 1; end <= length; end++) {
                uniqueSubstrings.add(word.substring(start, end));
            }
        }
    }
}