import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    static int n, m;
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // NOTE: 입력
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        map = new int[n][m];
        distance = new int[n][m];
        for(int i = 0; i < distance.length; i++){
            Arrays.fill(distance[i], -1);
        }
        visited = new boolean[n][m];

        int startR = 0, startC = 0;
        for(int i = 0; i < n; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < m; j++){
                map[i][j] = arr[j];
                if(map[i][j] == 2){
                    startR = i;
                    startC = j;
                }else if(map[i][j] == 0){
                    distance[i][j] = 0;
                }
            }
        }
        // NOTE: 거리 탐색 : bfs
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startR, startC));
        visited[startR][startC] = true;
        distance[startR][startC] = 0;

        int dis = 0;
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            dis += 1;

            for(int i = 0; i < 4; i++){
                int nx = cur.r + dx[i];
                int ny = cur.c + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == 0 || visited[nx][ny]) continue;
                distance[nx][ny] = distance[cur.r][cur.c] + 1;
                visited[nx][ny] = true;
                queue.add(new Point(nx,ny));
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Point{
    int r, c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
