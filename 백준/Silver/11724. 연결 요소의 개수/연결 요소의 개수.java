import com.sun.jdi.IntegerType;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] visited;
    static int[][] map;
    static Queue<Integer> queue = new LinkedList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = arr[0];
        m = arr[1];
        visited = new boolean[n + 1];
        map = new int[n + 1][n + 1];

        while(m-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u][v] = 1;
            map[v][u] = 1;
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    private static void bfs(int start){
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 1; i <= n; i++){
                if(map[cur][i] != 1 || visited[i])continue;
                queue.offer(i);
                visited[i] = true;
            }
        }
    }
}