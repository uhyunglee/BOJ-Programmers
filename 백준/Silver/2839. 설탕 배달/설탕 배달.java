import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();

        if(n == 4 || n == 7){
            System.out.println(-1);
        }else if(n % 5 == 0){
            System.out.println(n/5);
        }else if(n % 5 == 1){
            System.out.println(n/5 + 1);
        }else if(n % 5 == 2){
            System.out.println(n/5 + 2);
        }else if(n % 5 == 3){
            System.out.println(n/5 + 1);
        }else if(n % 5 == 4){
            System.out.println(n/5 + 2);
        }

    }
}