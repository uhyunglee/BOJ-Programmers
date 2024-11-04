import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] alphabet = new int[26];

        for(int i = 0; i < str.length(); i++){
            alphabet[str.charAt(i) - 97]++;
        }

        for(int i = 0; i < alphabet.length; i++){
            System.out.print(alphabet[i] + " ");
        }
    }
}
