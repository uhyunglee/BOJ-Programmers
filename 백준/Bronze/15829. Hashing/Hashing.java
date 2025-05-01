import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        final int r = 31;
        final int M = 1234567891;

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put((char)('a' + i), i + 1);
        }
        char[] arr = br.readLine().toCharArray();
        long answer = 0;
        for(int i = 0; i < arr.length; i++){
            int a = map.get(arr[i]);
            int rad = (int)Math.pow(31, i);
            answer += a * rad;
        }
        System.out.println(answer);
    }
}