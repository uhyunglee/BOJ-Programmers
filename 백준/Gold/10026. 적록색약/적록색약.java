import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x; this.y = y;
    }
}

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for (int i = 0; i < N; i++)
            grid[i] = br.readLine().toCharArray();

        visited = new boolean[N][N];
        int normal = countArea(false);

        visited = new boolean[N][N];
        int blind = countArea(true);

        System.out.println(normal + " " + blind);
    }

    private static int countArea(boolean isBlind) {
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j]) {
                    bfs(i, j, isBlind);
                    count++;
                }
        return count;
    }

    private static void bfs(int x, int y, boolean isBlind) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        char color = grid[x][y];

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d], ny = p.y + dy[d];
                if (isInBounds(nx, ny) && !visited[nx][ny] && isSameColor(color, grid[nx][ny], isBlind)) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    private static boolean isInBounds(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static boolean isSameColor(char c1, char c2, boolean isBlind) {
        if (!isBlind) return c1 == c2;
        if (c1 == 'B') return c2 == 'B';
        return c2 != 'B'; // R-G를 동일하게 취급
    }
}