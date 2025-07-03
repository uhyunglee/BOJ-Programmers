import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            // NOTE: 우선순위 큐에 삽입
            int num = Integer.parseInt(br.readLine());
            if(maxheap.isEmpty() || num < maxheap.peek()){
                maxheap.offer(num);
            }else
                minheap.offer(num);
            // NOTE: 중간값이 최상위 노드이도록 개수 조정
            if(maxheap.size() > minheap.size() + 1)
                minheap.offer(maxheap.poll());
            else if(minheap.size() > maxheap.size())
                maxheap.offer(minheap.poll());

            bw.write(maxheap.peek() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
