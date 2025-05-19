import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int start = 0, end = 0;
        int result = Integer.MAX_VALUE;

        while (end < n) {
            int diff = array[end] - array[start];

            if (start == end) {
                end++;
                continue;
            }

            if (diff >= m) {
                result = Math.min(result, diff);
                start++;
            } else {
                end++;
            }
        }

        System.out.println(result);
    }
}