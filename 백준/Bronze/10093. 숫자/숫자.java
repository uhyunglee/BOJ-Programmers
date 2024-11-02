import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        int firstNum = Math.min(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        int secondNum = Math.max(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));

        int cnt = firstNum != secondNum ? secondNum - firstNum - 1 : 0;

        System.out.println(cnt);
        if(cnt != 0) {
            int tmp = secondNum - 1;
            for (int i = firstNum + 1; i < secondNum - 1; i += 1) {
                System.out.print(i + " ");
            }
            System.out.println(tmp);
        }
    }
}
