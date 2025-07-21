import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = arr[N - 1];
            long total = 0L;
            for (int i = N - 2; i >= 0; i--) {
                if (arr[i] < max) { 
                    total += max - arr[i];
                } else {
                    max = arr[i];
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb.toString());
    }
}