import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int tmp = (int)Math.round(N * 0.15);
        double sum = 0;
        
        for(int i = tmp; i < N - tmp; i++)
            sum += arr[i];

        sb.append((int)Math.round(sum / (N - tmp * 2)));

        System.out.print(sb);
    }
}