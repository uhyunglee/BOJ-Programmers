import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] scores = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int score : scores){
            if(score > max){
                max = score;
            }
        }
        double avg = 0.0;
        for(int score : scores){
            avg += (double)score / max * 100;
        }
        System.out.println(avg / n);



    }
}