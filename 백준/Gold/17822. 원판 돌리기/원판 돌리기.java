import java.util.*;
import java.io.*;

public class Main {
    static int n, m, t;
    static int x, d, k;
    static boolean change;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Node{
        int x, y, v;
        public Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            change = false;

            int bea = 1;
            while(true) {
                int xx = (x * bea) - 1;
                if(xx >= n) break;
                rotation(xx);
                bea++;
            }

            for(int xx = 0; xx < n; xx++) {
                for(int yy = 0; yy < m; yy++) {
                    BFS(xx, yy, map[xx][yy]);
                }
            }

            if(!change) avgMap();
        }


        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void rotation(int x) {
        int kk = k;
        if(d == 1) kk = m - k;

        while(kk > 0) {
            int temp = map[x][m - 1];
            for(int i = m-1; i >= 1; i--)
                map[x][i] = map[x][i-1];
            map[x][0] = temp;
            kk--;
        }
    }

    public static void BFS(int x, int y, int v) {
        if(v == 0) return;

        Queue<Node> q = new LinkedList<>();
        boolean[][] check = new boolean[n][m];
        boolean flag = false;
        check[x][y] = true;
        q.add(new Node(x, y, v));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    if(ny < 0 && map[nx][m - 1] == cur.v && !check[nx][m - 1]) {
                        q.add(new Node(nx, m - 1, map[nx][m - 1]));
                        map[nx][m - 1] = 0;
                        check[nx][m - 1] = true;
                        flag = true;
                    }
                    else if(ny >= m && map[nx][0] == cur.v && !check[nx][0]) {
                        q.add(new Node(nx, 0, map[nx][0]));
                        map[nx][0] = 0;
                        check[nx][m - 1] = true;
                        flag = true;
                    }
                    continue;
                }

                if(map[nx][ny] == cur.v && !check[nx][ny]) {
                    q.add(new Node(nx,ny,map[nx][ny]));
                    map[nx][ny] = 0;
                    check[nx][ny] = true;
                    flag = true;
                }
            }
        }

        if(flag) {
            map[x][y] = 0;
            change = true;
        }
    }

    public static void avgMap() {
        double avg = 0, cnt = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0)continue;
                cnt++;
                sum += map[i][j];
            }
        }
        avg = sum / cnt;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0)continue;
                if(avg < map[i][j]) map[i][j]--;
                else if(avg > map[i][j]) map[i][j]++;
            }
        }
    }
}
