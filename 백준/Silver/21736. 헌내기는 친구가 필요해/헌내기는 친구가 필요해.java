import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    static int n, m;
    static String[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        visited = new boolean[n][m];

        // Point cur = new Point(0, 0);
        int curRow = 0;
        int curCol = 0;
        for(int i = 0; i < n; i++){
            map[i] = br.readLine().split("");
            for(int j = 0; j < m; j++){
                if(map[i][j].equals("I")){
                    curRow = i;
                    curCol = j;
                }
            }
        }

        int count = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(curRow, curCol));
        visited[curRow][curCol] = true;
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            for(int dir = 0; dir < 4; dir++){
                int nr = cur.r + dx[dir];
                int nc = cur.c + dy[dir];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m)continue;
                if(map[nr][nc].equals("X") || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                if(map[nr][nc].equals("P")) count++;
                queue.add(new Point(nr, nc));
            }
        }
        if(count == 0)
            System.out.println("TT");
        else System.out.println(count);
    }
}
class Point{
    int r, c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
