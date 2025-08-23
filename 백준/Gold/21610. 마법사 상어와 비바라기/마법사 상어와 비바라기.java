import java.util.*;
import java.io.*;

public class Main {
    static int N, M, d, s;
    static int[][] bucket;
    static boolean[][] visited;
    static List<int[]> cloud;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        bucket = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                bucket[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        cloud = new ArrayList<>();
        cloud.add(new int[]{N-2,0});
        cloud.add(new int[]{N-2,1});
        cloud.add(new int[]{N-1,0});
        cloud.add(new int[]{N-1,1});

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            d = Integer.parseInt(stringTokenizer.nextToken());
            s = Integer.parseInt(stringTokenizer.nextToken());

            visited = new boolean[N][N];
            moveCloud(d, s);
            checkDiagonal();
            makeCloud();
        }

        int result = calOfWater();
        System.out.println(result);
    }

    private static int calOfWater() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += bucket[i][j];
            }
        }
        return sum;
    }

    private static void makeCloud() {
        cloud = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (bucket[i][j] >= 2 && !visited[i][j]) {
                    bucket[i][j] -= 2;
                    cloud.add(new int[]{i, j});
                }
            }
        }
    }

    private static void checkDiagonal() {
        for (int[] c : cloud) {
            int cnt = 0;
            for (int d = 2; d < 9; d += 2) {
                int nx = c[0] + dx[d];
                int ny = c[1] + dy[d];

                if (nx < 0 || ny < 0 || N <= nx || N <= ny) continue;
                if(bucket[nx][ny] > 0) cnt++;
            }
            bucket[c[0]][c[1]] += cnt;
        }
    }

    private static void moveCloud(int d, int s) {
        for (int[] c : cloud) {
            int nx = (c[0] + N + dx[d] * s % N) % N;
            int ny = (c[1] + N + dy[d] * s % N) % N;

            visited[nx][ny] = true;
            bucket[nx][ny] += 1;
            c[0] = nx;
            c[1] = ny;
        }
    }
}
