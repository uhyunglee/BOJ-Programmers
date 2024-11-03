import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= 9; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > max) {
                max = num;
                idx = i;
            }
        }
        bw.write(max + "\n");
        bw.write(idx + "\n");
        bw.flush();
    }
}
