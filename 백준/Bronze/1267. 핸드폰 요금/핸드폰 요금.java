import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = 0;
        int M = 0;

        while(st.hasMoreTokens()){
            int time = Integer.parseInt(st.nextToken());
            Y += ((time / 30) + 1) * 10;
            M += ((time / 60) + 1) * 15;
        }
        if(Y > M){
            bw.write("M " + M);
        }else if(Y < M){
            bw.write("Y " + Y);
        }else{
            bw.write("Y M " + M);
        }
        bw.flush();
    }
}
