import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        long firstNum = Math.min(Long.parseLong(arr[0]), Long.parseLong(arr[1]));
        long secondNum = Math.max(Long.parseLong(arr[0]), Long.parseLong(arr[1]));

        long cnt = firstNum != secondNum ? secondNum - firstNum - 1 : 0;

        System.out.println(cnt);
        if(cnt != 0) {
            for (long i = firstNum + 1; i < secondNum; i += 1) {
                System.out.print(i + " ");
            }
        }
    }
}
