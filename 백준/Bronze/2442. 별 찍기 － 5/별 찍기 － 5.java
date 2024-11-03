import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            for(int j = N-(i+1); j >0; j--){
                System.out.print(" ");
            }
            for(int j = 0; j < (2*i) + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
