import java.util.*;
import java.io.*;

class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int[] dx = {2, 1, -1, -2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        while(tc-- > 0){
            Queue<Point> q = new LinkedList<>();
                int n = Integer.parseInt(br.readLine());
                int[][] board = new int[n][n];
                int[][] visited = new int[n][n];

                String[] line = br.readLine().split(" ");
                int curX = Integer.parseInt(line[0]);
                int curY = Integer.parseInt(line[1]);
                board[curX][curY] = 1;
                q.add(new Point(curX, curY));

                line = br.readLine().split(" ");
                int nextX = Integer.parseInt(line[0]);
                int nextY = Integer.parseInt(line[1]);
                while(!q.isEmpty()) {
                    Point cur = q.poll();
                    if(cur.x == nextX && cur.y == nextY)break;
                    for (int j = 0; j < 8; j++) {
                        int nx = cur.x + dx[j];
                        int ny = cur.y + dy[j];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if (visited[nx][ny] != 0) continue;
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                        q.add(new Point(nx, ny));
                    }
                }
                System.out.println(visited[nextX][nextY]);
        }

    }
}