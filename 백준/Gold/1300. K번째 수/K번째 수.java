// 시간복잡도: O(N)
// 접근방법: 이분탐색 
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int lo = 1;
        int hi = K;

        while(lo < hi) {
            int mid = (lo + hi) / 2;
            int count = 0;

            for(int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            if(K <= count) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}