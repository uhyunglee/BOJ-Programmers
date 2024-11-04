import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        long result = a * b * c;
        int[] arr = new int[10];
        StringBuilder sb = new StringBuilder(result + "");

        for(int i = 0; i < sb.length(); i++){
            arr[sb.charAt(i) - 48]++;
        }
        for(int i = 0 ; i < arr.length; i++){
            bw.write(arr[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
