import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] space;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Target{
        int x, y, dist;
        Target(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];

        int sx = -1, sy = -1;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                space[i][j] = Integer.parseInt(st.nextToken());
                if(space[i][j] == 9){
                    sx = i;
                    sy = j;
                    space[i][j] = 0;;
                }
            }
        }
        int size = 2, eaten = 0, time = 0;
        while(true){
            Target t = findNext(sx, sy, size);
            if(t == null) break;
            time += t.dist;
            space[t.x][t.y] = 0;
            sx = t.x;
            sy = t.y;
            if(++eaten == size){
                eaten = 0;
                size++;
            }
        }
        System.out.println(time);
    }
    static Target findNext(int sx, int sy, int size){
        boolean[][] visited = new boolean[N][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        int minDist = Integer.MAX_VALUE;
        int tx = -1, ty = -1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];

            if(d > minDist) break;
            if(space[x][y] != 0 && space[x][y] < size){
                if(d < minDist || (d == minDist && (x < tx || (x == tx && y < ty)))){
                    minDist = d;
                    tx = x;
                    ty = y;
                }
            }
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir], ny = y + dy[dir];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(space[nx][ny] > size) continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, d + 1});
            }
        }
        return (tx == -1) ? null : new Target(tx, ty, minDist);
    }
}
