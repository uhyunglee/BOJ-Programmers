import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Problem> problems = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            problems.add(new Problem(deadline, ramen));
        }
        problems.sort((a, b) -> a.deadline - b.deadline);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Problem p : problems){
            minHeap.offer(p.ramen);
            if(minHeap.size() > p.deadline)
                minHeap.poll();
        }

        int sum = 0;
        while(!minHeap.isEmpty()){
            sum += minHeap.poll();
        }
        System.out.println(sum);
    }
}
class Problem{
    int deadline;
    int ramen;
    public Problem(int deadline, int ramen){
        this.deadline = deadline;
        this.ramen = ramen;
    }
}
