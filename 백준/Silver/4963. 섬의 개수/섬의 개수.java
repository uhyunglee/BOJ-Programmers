import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
        while((line = br.readLine()) != null){
            // NOTE: 입력
            int[] size = Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            w = size[0];
            h = size[1];
            if(w == 0 && h == 0) break;
            map = new int[h][w];
            visited = new boolean[h][w];
            int count = 0;
            for(int i = 0; i < h; i++){
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int j = 0; j < w; j++){
                    map[i][j] = arr[j];
                }
            }
            // NOTE: 섬의 개수 탐색(bfs)
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(map[i][j] == 0 || visited[i][j]) continue;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        Point cur = queue.poll();
                        for(int dir = 0; dir < 8; dir++){
                            int nx = cur.r + dx[dir];
                            int ny = cur.c + dy[dir];
                            if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                            if(map[nx][ny] == 0 || visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            queue.add(new Point(nx, ny));
                        }
                    }
                    count++;
                }
            }
            System.out.println(count);
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
