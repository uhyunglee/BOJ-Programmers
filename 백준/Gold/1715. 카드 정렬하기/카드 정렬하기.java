import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int sum = 0;

        while ((pq.size() > 1)) {
            int a = pq.poll();
            int b = pq.poll();
            sum += (a + b);
            pq.add(a + b);
        }

        System.out.println(sum);
    }
}