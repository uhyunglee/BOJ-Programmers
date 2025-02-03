import java.util.*;
import java.io.*;

class Point{
    int r, c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}

class Main{
    static int[][] map;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[r][c];
            visited = new int[r][c];
            int worm = 0;
            Queue<Point> queue = new LinkedList<>();

            // NOTE: 배추 있는 곳 입력
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            // NOTE: BFS 탐색
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(map[i][j] == 1 && visited[i][j] == 0){
                        queue.add(new Point(i, j));
                        worm++;
                        while(!queue.isEmpty()){
                            Point cur = queue.poll();
                            for(int n = 0; n < 4; n++){
                                int nr = cur.r + dr[n];
                                int nc = cur.c + dc[n];
                                if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                                if(map[nr][nc] == 0 || visited[nr][nc] == 1) continue;
                                visited[nr][nc] = 1;
                                queue.add(new Point(nr, nc));
                            }
                        }
                    }
                }
            }
            System.out.println(worm);
        }
    }
}