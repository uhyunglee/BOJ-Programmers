import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[44];
        for(int i = 0; i < arr.length; i++){
            int n = i + 1;
            arr[i] = n * (n+1) / 2;
        }

        for(int testCase = 0; testCase < T; testCase++){
            int tcNum = sc.nextInt();
            boolean isEureka = false;
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr.length; j++){
                    for(int k = 0; k < arr.length; k++){

                        if((arr[i] + arr[j] + arr[k]) == tcNum)
                            isEureka = true;
                    }
                }
            }
            if(isEureka == true)
                System.out.println("1");
            else System.out.println("0");
        }

    }
}