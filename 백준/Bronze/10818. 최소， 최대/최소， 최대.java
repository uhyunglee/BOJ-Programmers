import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(n -- > 0){
            int num = sc.nextInt();
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