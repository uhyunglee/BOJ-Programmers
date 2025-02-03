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
    static char[][] grid;
    static int[][] visited;
    static int N;
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for(int i = 0; i < N; i++){
            grid[i] = br.readLine().toCharArray();
        }

        visited = new int[N][N];
        int normal = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] == 0){
                    bfs(i, j, false);
                    normal++;
                }
            }
        }

        visited = new  int[N][N];
        int blind = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] == 0){
                    bfs(i, j, true);
                    blind++;
                }
            }
        }
        System.out.println(normal + " " + blind);

    }
    public static void bfs(int startX, int startY, boolean isBlind){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startX][startY] = 1;
        char color = grid[startX][startY];

        while(!queue.isEmpty()){
            Point cur = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(isOutRange(nx, ny) || visited[nx][ny] == 1) continue;

                if(isBlind){
                    if(!isSameColor(color, grid[nx][ny])) continue;
                }else{
                    if(color != grid[nx][ny]) continue;
                }
                visited[nx][ny] = 1;
                queue.add(new Point(nx, ny));
            }
        }
    }
    public static boolean isOutRange(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }
    public static boolean isSameColor(char c1, char c2){
        if(c1 == 'B') return c2 == 'B';
        return c2 != 'B';
    }
}