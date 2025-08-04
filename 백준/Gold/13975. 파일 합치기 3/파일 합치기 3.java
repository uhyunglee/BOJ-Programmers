import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int i = 1; i <= tc; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for(int j = 0; j < n; j++){
                pq.add(Long.parseLong(st.nextToken()));
            }
            long sum = 0;

            while(pq.size() > 1){
                long x = pq.poll();
                long y = pq.poll();
                sum += x + y;
                pq.add(x + y);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}
