import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n -- > 0){
            int num = Integer.parseInt(st.nextToken());
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }
        System.out.println(min + " " + max);
    }
}