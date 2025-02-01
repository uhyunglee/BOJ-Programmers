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
    static int w, h; // h: row, w: column
    static char[][] map;
    static int[][] visited;
    static int[][] fire;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Point cur;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0){
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // col
            h = Integer.parseInt(st.nextToken()); // row
            map = new char[h][w];
            visited = new int[h][w];
            fire = new int[h][w];
            Queue<Point> queue = new LinkedList<>();
            Queue<Point> fireQueue = new LinkedList<>();
            for(int i = 0; i < h; i++){
                char[] input = br.readLine().toCharArray();
                for(int j = 0; j < w; j++){
                    map[i][j] = input[j];
                    if(map[i][j] == '@'){
                        queue.add(new Point(i, j));
                        visited[i][j] = 1;
                    }else if(map[i][j] == '#'){ // NOTE: 벽을 만남
                        fire[i][j] = -1;
                        visited[i][j] = -1;
                    }else if(map[i][j] == '*'){
                        fireQueue.add(new Point(i, j));
                        fire[i][j] = 1;
                    }
                }
            }
            // NOTE: 먼저 불의 전파를 기록
            while(!fireQueue.isEmpty()){
                Point now = fireQueue.poll();
                for(int i = 0; i < 4; i++){
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if(fire[nx][ny] == 0){
                        fire[nx][ny] = fire[now.x][now.y] + 1;
                        fireQueue.add(new Point(nx, ny));
                    }
                }
            }
            boolean isEscaped = false;
            while(!queue.isEmpty()){
                Point now = queue.poll();
                if(now.x == 0 || now.x == h - 1 || now.y == 0 || now.y == w - 1){
                    System.out.println(visited[now.x][now.y]);
                    isEscaped = true;
                    break;
                }
                for(int i = 0; i < 4; i++){
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if(visited[nx][ny] != 0) continue;
                    if(fire[nx][ny] == 0 || fire[nx][ny] > visited[now.x][now.y] + 1){
                        visited[nx][ny] = visited[now.x][now.y] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            if(!isEscaped){ // NOTE: 탈출을 못했을 때
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}