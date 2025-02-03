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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        visited = new int[N][N];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < N; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                grid[i][j] = line[j];
            }
        }
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> blindQueue = new LinkedList<>();
        int normal = 0;
        int blind = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == 'R' && visited[i][j] == 0){
                    queue.add(new Point(i, j));
                    normal++;
                    while(!queue.isEmpty()){
                        Point cur = queue.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if(visited[nx][ny] == 1 || grid[nx][ny] == 'G' || grid[nx][ny] == 'B') continue;
                            visited[nx][ny] = 1;
                            queue.add(new Point(nx, ny));
                        }
                    }

                }else if(grid[i][j] == 'G' && visited[i][j] == 0){
                    queue.add(new Point(i, j));
                    normal++;
                    while(!queue.isEmpty()){
                        Point cur = queue.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if(visited[nx][ny] == 1 || grid[nx][ny] == 'R' || grid[nx][ny] == 'B') continue;
                            visited[nx][ny] = 1;
                            queue.add(new Point(nx, ny));
                        }
                    }
                }else if(grid[i][j] == 'B' && visited[i][j] == 0){
                    queue.add(new Point(i, j));
                    normal++;
                    while(!queue.isEmpty()){
                        Point cur = queue.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if(visited[nx][ny] == 1 || grid[nx][ny] == 'R' || grid[nx][ny] == 'G') continue;
                            visited[nx][ny] = 1;
                            queue.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        // NOTE: 적록색맹 BFS
        visited = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if((grid[i][j] == 'R' || grid[i][j] == 'G') && visited[i][j] == 0){
                    blindQueue.add(new Point(i, j));
                    blind++;
                    while(!blindQueue.isEmpty()){
                        Point cur = blindQueue.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if(visited[nx][ny] == 1 || grid[nx][ny] == 'B') continue;
                            visited[nx][ny] = 1;
                            blindQueue.add(new Point(nx, ny));
                        }
                    }
                }else if(grid[i][j] == 'B' && visited[i][j] == 0){
                    blindQueue.add(new Point(i, j));
                    blind++;
                    while(!blindQueue.isEmpty()){
                        Point cur = blindQueue.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if(visited[nx][ny] == 1 || grid[nx][ny] == 'R' || grid[nx][ny] == 'G' ) continue;
                            visited[nx][ny] = 1;
                            blindQueue.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        System.out.println(normal + " " + blind);
    }
}