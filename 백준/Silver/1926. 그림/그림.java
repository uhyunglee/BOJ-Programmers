import java.io.*;
import java.util.*;
import java.util.stream.*;


class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<Point> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int max = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0 || visited[i][j]) continue;
                count++;
                visited[i][j] = true;
                queue.offer(new Point(i, j));
                int area = 0;
                while(!queue.isEmpty()){
                    area++;
                    Point cur = queue.poll();
                    for(int dir = 0; dir < 4; dir++){
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if(visited[nx][ny] || map[nx][ny] != 1) continue;
                        visited[nx][ny] = true;
                        queue.push(new Point(nx, ny));
                    }
                }
                max = Math.max(max, area);
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}