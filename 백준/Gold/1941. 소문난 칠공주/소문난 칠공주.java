// 시간복잡도: O(25C7)
// 접근방법: BFS, 조합
import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static char[][] squre;
    static int result;
    static boolean[]  totalVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        squre = new char[5][5];
        totalVisited = new boolean[25];
        for(int i = 0;i < 5;i++){
            String line = br.readLine();
            for(int j = 0;j < 5;j++){
                squre[i][j] = line.charAt(j);
            }
        }
        search(0, 0, 0);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    static void search(int idx, int depth, int yCnt){
        if(yCnt >= 4){
            return;
        }
        if(depth == 7){
            int curIdx = idx-1;
            if(bfs(curIdx / 5, curIdx % 5)){
                result++;
            }
            return;
        }
        for(int i = idx; i < 25; i++){
            totalVisited[i] = true;
            if(squre[i / 5][i % 5] == 'Y'){
                search(i+1, depth+1, yCnt+1);
            }else{
                search(i+1, depth+1, yCnt);
            }
            totalVisited[i] = false;
        }
    }
    static boolean bfs(int r, int c){
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;
        queue.offer(new Point(r, c));
        int cnt = 1;
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            for(int i = 0;i < 4;i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                int nxt = nr * 5 + nc;
                if(inSpace(nr, nc) && !visited[nr][nc] && totalVisited[nxt]){
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc));
                    cnt++;
                }
            }
        }
        return cnt == 7;
    }
    static boolean inSpace(int r, int c){
        if(r >= 0 && c >= 0 && r < 5 && c < 5){
            return true;
        }
        return false;
    }
}