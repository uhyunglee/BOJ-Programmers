import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        String[] arr = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i+=1){
            int num = Integer.parseInt(arr[i]);
            if(num < X){
                sb.append(num + " ");
            }
        }
        System.out.println(sb.toString());
    }
}
