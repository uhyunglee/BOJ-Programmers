import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    static int n;
    static int m;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        while(m-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from][to] = 1;
            map[to][from] = 1;
        }

        bfs();

        System.out.println(count);
    }

    static void bfs(){
        queue.offer(1); // 시작점
        visited[1] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i = 1; i <= n; i++){
                if(map[node][i] != 1 || visited[i]) continue;

                queue.offer(i);
                visited[i] = true;
                count++;
            }
        }
    }
}