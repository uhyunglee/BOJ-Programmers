import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> queue = IntStream.range(0, n).map(i -> i + 1).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        sb.append("<");
        while(queue.size() != 1){
            for(int i = 0; i < k-1; i++){
                queue.addLast(queue.poll());
           }
            sb.append(queue.poll() + ", ");
        }
        sb.append(queue.poll() + "> ");

        System.out.println(sb.toString());
    }
}