// 시간복잡도: O(N * M * K)
// 접근방법: 벽 부순 횟수에 따라 분기처리
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.r == N - 1 && cur.c == M - 1) return cur.dist;

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                // 빈 칸
                if (map[nr][nc] == 0 && !visited[nr][nc][cur.breakCount]) {
                    visited[nr][nc][cur.breakCount] = true;
                    queue.add(new Point(nr, nc, cur.breakCount, cur.dist + 1));
                }
                // 벽이고 아직 부술 수 있음
                else if (map[nr][nc] == 1 && cur.breakCount < K && !visited[nr][nc][cur.breakCount + 1]) {
                    visited[nr][nc][cur.breakCount + 1] = true;
                    queue.add(new Point(nr, nc, cur.breakCount + 1, cur.dist + 1));
                }
            }
        }

        return -1;
    }

    static class Point {
        int r, c, breakCount, dist;
        public Point(int r, int c, int breakCount, int dist) {
            this.r = r;
            this.c = c;
            this.breakCount = breakCount;
            this.dist = dist;
        }
    }
}