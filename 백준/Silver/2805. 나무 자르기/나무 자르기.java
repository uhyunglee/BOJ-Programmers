import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long left = 0, right = max, answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for(int tree : trees) {
                if(tree > mid) sum += (tree - mid);
            }

            if(sum >= m) {
                answer = mid; // 가능한 높이 중 최대값을 저장
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}