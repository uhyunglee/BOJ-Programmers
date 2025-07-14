import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        for(int i = 1; i < n; i++) {
            dp[i] = arr[i];
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[j] + arr[i] > dp[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int value : dp) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println(max);
    }
}