// 시간복잡도: O(N + E)
// 접근방법: BFS
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] populationMap;
    static int mapSize, minDiff, maxDiff;
    static boolean hasPopulationMoved;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        mapSize = Integer.parseInt(st.nextToken());
        minDiff = Integer.parseInt(st.nextToken());
        maxDiff = Integer.parseInt(st.nextToken());
        populationMap = new int[mapSize][mapSize];

        for (int r = 0; r < mapSize; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < mapSize; c++) {
                populationMap[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;

        while (true) {
            visited = new boolean[mapSize][mapSize];
            hasPopulationMoved = false;

            for (int r = 0; r < mapSize; r++) {
                for (int c = 0; c < mapSize; c++) {
                    if (!visited[r][c]) {
                        bfs(r, c);
                    }
                }
            }
            if (!hasPopulationMoved)
                break;
            days++;
        }
        System.out.println(days);
    }

    private static void bfs(int startR, int startC) {
        Queue<Position> unionQueue = new LinkedList<>();
        Queue<Position> bfsQueue = new LinkedList<>();

        bfsQueue.add(new Position(startR, startC));
        unionQueue.add(new Position(startR, startC));
        visited[startR][startC] = true;

        int populationSum = populationMap[startR][startC];

        while (!bfsQueue.isEmpty()) {
            Position cur = bfsQueue.poll();
            int x = cur.x;
            int y = cur.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= mapSize || ny >= mapSize)
                    continue;
                if (visited[nx][ny])
                    continue;

                int diff = Math.abs(populationMap[x][y] - populationMap[nx][ny]);
                if (diff >= minDiff && diff <= maxDiff) {
                    visited[nx][ny] = true;
                    unionQueue.add(new Position(nx, ny));
                    bfsQueue.add(new Position(nx, ny));
                    populationSum += populationMap[nx][ny];
                }
            }
        }

        if (unionQueue.size() > 1) {
            int average = populationSum / unionQueue.size();
            hasPopulationMoved = true;

            for (Position pos : unionQueue) {
                populationMap[pos.x][pos.y] = average;
            }
        }
    }

    static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}