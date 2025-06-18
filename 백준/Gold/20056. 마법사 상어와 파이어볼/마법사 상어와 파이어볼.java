// 시간복잡도: O(k * n^2)
// 접근방법: BFS, 구현
import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, k;

    public static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    public static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
    public static ArrayList<Node>[][] grid;

    public static class Node {
        int r;
        int c;
        int m;
        int d;
        int s;

        public Node(int r, int c, int m, int d, int s) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new ArrayList[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (grid[x - 1][y - 1] == null) {
                grid[x - 1][y - 1] = new ArrayList<>();
            }
            grid[x - 1][y - 1].add(new Node(x - 1, y - 1, m, d, s));
        }

        while (k-- > 0) {
            ArrayList<Node>[][] nextGrid = new ArrayList[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == null) continue;

                    for (int p = 0; p < grid[i][j].size(); p++) {
                        Node fireball = grid[i][j].get(p);

                        int nx = fireball.r + dr[fireball.d] * (fireball.s % n);
                        int ny = fireball.c + dc[fireball.d] * (fireball.s % n);

                        if (nx < 0) {
                            nx = n - Math.abs(nx);
                        } else if (nx >= n) {
                            nx -= n;
                        }
                        if (ny < 0) {
                            ny = n - Math.abs(ny);
                        } else if (ny >= n) {
                            ny -= n;
                        }

                        if (nextGrid[nx][ny] == null) {
                            nextGrid[nx][ny] = new ArrayList<>();
                        }
                        nextGrid[nx][ny].add(new Node(nx, ny, fireball.m, fireball.d, fireball.s));
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (nextGrid[i][j] == null || nextGrid[i][j].size() == 1) continue;

                    int totalMass = 0;
                    int totalSpeed = 0;
                    int size = nextGrid[i][j].size();
                    boolean hasOdd = false;
                    boolean hasEven = false;

                    for (int p = 0; p < size; p++) {
                        Node fireball = nextGrid[i][j].get(p);
                        totalMass += fireball.m;
                        totalSpeed += fireball.s;

                        if (fireball.d % 2 == 0) {
                            hasEven = true;
                        } else {
                            hasOdd = true;
                        }
                    }

                    nextGrid[i][j].clear();

                    if (totalMass / 5 == 0) continue;

                    int newMass = totalMass / 5;
                    int newSpeed = totalSpeed / size;
                    int[] directions = (hasOdd && hasEven) ? new int[] { 1, 3, 5, 7 } : new int[] { 0, 2, 4, 6 };

                    for (int dir : directions) {
                        nextGrid[i][j].add(new Node(i, j, newMass, dir, newSpeed));
                    }
                }
            }

            grid = nextGrid;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == null) continue;
                for (int p = 0; p < grid[i][j].size(); p++) {
                    answer += grid[i][j].get(p).m;
                }
            }
        }

        System.out.println(answer);
    }
}