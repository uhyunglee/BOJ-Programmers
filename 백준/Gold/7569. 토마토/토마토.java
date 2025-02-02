import java.util.*;
import java.io.*;

class Point{
    int x, y, z;
    public Point(int z, int x, int y){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Main{
    static int m, n, h;
    static int[][][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        int answer = 0;
        visited = new int[h][n][m];
        Queue<Point> q = new LinkedList<>();


        for(int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                int[] line = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < m; j++) {
                    if (line[j] == 0) {
                        visited[k][i][j] = -1;
                    } else if (line[j] == 1) {
                        q.add(new Point(k, i, j));
                    }
                }
            }
        }

        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i = 0; i < 6; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];
                if(isOut(nz, nx, ny)) continue;
                if(visited[nz][nx][ny] >= 0) continue;
                visited[nz][nx][ny] = visited[cur.z][cur.x][cur.y] + 1;
                q.add(new Point(nz, nx, ny));
            }
        }
        // 익지 못한 토마토가 있는 경우 -> -1
        for(int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[k][i][j] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, visited[k][i][j]);
                }
            }
        }
        System.out.println(answer);
    }
    static boolean isOut(int nz, int nx, int ny){
        return nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h;
    }
}