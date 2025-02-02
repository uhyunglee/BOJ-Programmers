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
    static int m, n;
    static int[][] visited;
    static int[][] tomato;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;
        visited = new int[n][m];
        tomato = new int[n][m];
        Queue<Point> q = new LinkedList<>();


        for(int i = 0; i < n; i++){
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < m; j++){
                if(line[j] == 0){
                    visited[i][j] = -1;
                }else if(line[j] == 1){
                    q.add(new Point(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(isOut(nx, ny)) continue;
                if(visited[nx][ny] >= 0) continue;
                visited[nx][ny] = visited[cur.x][cur.y] + 1;
                q.add(new Point(nx, ny));
            }
        }
        // 익지 못한 토마토가 있는 경우 -> -1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == -1){
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, visited[i][j]);
            }
        }
        System.out.println(answer);
    }
    static boolean isOut(int nx, int ny){
        return nx < 0 || nx >= n || ny < 0 || ny >= m;
    }
}