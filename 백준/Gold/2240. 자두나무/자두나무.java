import java.util.*;
import java.io.*;

public class Main {
    static int t, w, tree;
    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        dp = new int[t+1][w+1];

        for (int i=1; i<=t; i++) {
            tree = Integer.parseInt(br.readLine());

            for (int j=0; j<=w; j++) {

                if (j == 0) {
                    if (tree == 1) { dp[i][j] = dp[i-1][j] + 1; }
                    else { dp[i][j] = dp[i-1][j];}

                    continue;
                }

                if (j%2 == 0) {
                    if (tree == 1) {
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1); 
                    }
                } else {
                    if (tree == 1) {
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    }
                }
            }
        }

        int ans = 0;
        for (int k=0; k<=w; k++) {
            ans = Math.max(ans, dp[t][w]);
        }

        System.out.println(ans);
    }
}