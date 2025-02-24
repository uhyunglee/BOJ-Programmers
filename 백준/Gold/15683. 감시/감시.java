import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][][] mode = {
            {{0}},
            {{0}, {1}, {2}, {3}}, // 1번
            {{1, 3}, {0, 2}}, // 2번
            {{0, 1}, {1, 2}, {2, 3}, {0, 3}}, // 3번
            {{0, 1, 3}, {0, 1, 2}, {0, 2, 3}, {1, 2, 3}}, // 4번
            {{0, 1, 2, 3}} // 5번
    };

    static ArrayList<Node> cctv;
    static class Node{
        int x;
        int y;
        int type;
        public Node(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static int n, m, ans;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cctv = new ArrayList<>();
        int zeroCount = 0;
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5){
                    cctv.add(new Node(i, j, map[i][j]));
                }else if(map[i][j] == 0)
                    zeroCount++;
            }
        }
        ans = zeroCount;
        combination(0, cctv.size(), map);
        System.out.println(ans);
    }

    static void combination(int depth, int r, int[][] map){
        // base
        if(depth == r){
            int cnt = check(map);
            ans = Math.min(ans, cnt);
            return;
        }
        int cctvType = cctv.get(depth).type;
        int x = cctv.get(depth).x;
        int y = cctv.get(depth).y;

        for(int i = 0; i < mode[cctvType].length; i++){
            int[][] mapCopy = new int[n][m];
            for(int k = 0; k < n; k++){
                mapCopy[k] = map[k].clone();
            }

            for(int j = 0; j < mode[cctvType][i].length; j++){
                int dir = mode[cctvType][i][j];

                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while(true){
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
                    if(map[nx][ny] == 6) break; // 벽인 경우
                    mapCopy[nx][ny] = -1; // 탐색 완료
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }

            combination(depth + 1, r, mapCopy);
        }
    }

    static int check(int[][] map){ // 사각지대를 구하는 함수
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}