import java.util.*;
import java.io.*;

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // NOTE: Input 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[101][101];
        int[][] dist = new int[101][101];
        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split("");
            Arrays.fill(dist[i], -1);
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(str[j]);
            }
        }
        int count = 0;
        ArrayDeque<Point> queue = new ArrayDeque<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        queue.add(new Point(0, 0));
        dist[0][0] = 0;

        while(!queue.isEmpty()){
            Point cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(dist[nx][ny] >= 0 || board[nx][ny] == 0) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                queue.add(new Point(nx, ny));
            }
        }
        System.out.println(dist[n-1][m-1] + 1);
    }
}