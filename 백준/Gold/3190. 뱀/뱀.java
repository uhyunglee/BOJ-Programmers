import java.util.*;
import java.io.*;

public class Main {
    static int n, dir = 0;
    static int[][] map;
    static Map<Integer, String> moveInfo;
    static int[] dx = {1, 0, -1, 0}; 
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        map = new int[n][n];
        moveInfo = new HashMap<>();

        for (int i = 0; i < k; i++) {
            String[] parts = br.readLine().split(" ");
            int y = Integer.parseInt(parts[0]) - 1;
            int x = Integer.parseInt(parts[1]) - 1;
            map[y][x] = 1; 
        }

        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            String[] parts = br.readLine().split(" ");
            moveInfo.put(Integer.parseInt(parts[0]), parts[1]);
        }

        System.out.println(simulate());
    }

    static int simulate() {
        Deque<int[]> snake = new LinkedList<>();
        Set<Integer> snakeSet = new HashSet<>();

        int x = 0, y = 0, time = 0;
        snake.add(new int[]{x, y});
        snakeSet.add(pos(x, y));

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!inRange(nx, ny) || snakeSet.contains(pos(nx, ny))) break;

            snake.addLast(new int[]{nx, ny});
            snakeSet.add(pos(nx, ny));
            if (map[ny][nx] == 1) {
                map[ny][nx] = 0;
            } else {
                int[] tail = snake.pollFirst();
                snakeSet.remove(pos(tail[0], tail[1]));
            }

            if (moveInfo.containsKey(time)) {
                String turn = moveInfo.get(time);
                dir = (dir + (turn.equals("D") ? 1 : 3)) % 4;
            }

            x = nx;
            y = ny;
        }

        return time;
    }

    static int pos(int x, int y) {
        return y * n + x;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}