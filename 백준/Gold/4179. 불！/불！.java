import java.util.*;
import java.io.*;

 class Point{
     int r,c;
     public Point(int r, int c){
         this.r = r;
         this.c = c;
     }
 }

class Main{
     static int r, c;
     static int[][] fire;
     static int[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        fire = new int[r][c];
        visited = new int[r][c];
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> fireQueue = new LinkedList<>();

        for(int i = 0; i < r; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < c; j++){
                if(line[j] == '#'){
                    visited[i][j] = -1;
                    fire[i][j] = -1;
                }else if(line[j] == 'J'){
                    queue.add(new Point(i, j));
                    visited[i][j] = 1;
                }else if(line[j] == 'F'){
                    fireQueue.add(new Point(i, j));
                    fire[i][j] = 1;
                }
            }
        }

        while(!fireQueue.isEmpty()){
            Point cur = fireQueue.poll();
            for(int i = 0; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(isOut(nr, nc))continue;
                if(fire[nr][nc] == 0){
                    fire[nr][nc] = fire[cur.r][cur.c] + 1;
                    fireQueue.add(new Point(nr, nc));
                }
            }
        }

        boolean isEscaped = false;
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            if(isExit(cur.r, cur.c)){
                isEscaped = true;
                System.out.println(visited[cur.r][cur.c]);
                break;
            }
            for(int i = 0; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(isOut(nr, nc))continue;
                if(visited[nr][nc] != 0) continue;
                if(fire[nr][nc] == 0 || fire[nr][nc] > visited[cur.r][cur.c] + 1){
                    visited[nr][nc] = visited[cur.r][cur.c] + 1;
                    queue.add(new Point(nr, nc));
                }
            }
        }
        if(!isEscaped)
            System.out.println("IMPOSSIBLE");
    }
    static boolean isOut(int nr, int nc){
        return nr < 0 || nr >= r || nc < 0 || nc >= c;
    }
    static boolean isExit(int nr, int nc){
        return nr == 0 || nr == r - 1 || nc == 0 || nc == c - 1;
    }
}