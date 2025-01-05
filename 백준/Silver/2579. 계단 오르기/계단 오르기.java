import java.io.*;
import java.util.*;

class Main {
    static Integer dp[];
    static int scores[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1];
        scores = new int[n + 1];
        long maxScore = 0;

        for(int i = 1; i < n + 1; i+=1){
            scores[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = scores[0];
        dp[1] = scores[1];

        if(n >= 2) dp[2] = scores[1] + scores[2];

        System.out.println(step(n));
    }
    static int step(int n){
        if(dp[n] == null){
            dp[n] = Math.max(step(n - 2), step(n - 3) + scores[n - 1]) + scores[n];
        }
        return dp[n];
    }
}