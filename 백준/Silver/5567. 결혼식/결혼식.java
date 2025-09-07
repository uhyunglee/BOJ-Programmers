import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[] visited;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        // Input
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u][v] = map[v][u] = 1;
        }

        // Search
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (map[1][i] == 1) { // 상근이와 직접 연겲
                if (!visited[i]) {
                    visited[i] = true;
                    count++;
                }
                for (int j = 2; j <= n; j++) { // 상근이와 간접 연결
                    if (map[i][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}