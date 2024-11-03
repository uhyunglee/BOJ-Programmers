import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N-1; i++){
            for(int j = N - 1; j > i; j--){
                System.out.print(" ");
            }
            for(int j = 0; j < (2*i) + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = N; i > 0; i--){
            for(int j = 0; j < N - i; j++){
                System.out.print(" ");
            }
            for(int j = (2*i)-1; j > 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
