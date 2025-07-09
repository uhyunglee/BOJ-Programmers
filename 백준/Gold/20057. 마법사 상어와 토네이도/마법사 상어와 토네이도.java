import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static int spreadR[][] = {
            {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
            {0, 0, 1, 1, 2, 2, 1, 1, 3, 2},
            {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
            {0, 0, -1, -1, -2, -2, -1, -1, -3, -2}
    };
    static int spreadC[][] = {
            {0, 0, -1, -1, -2, -2, -1, -1, -3, -2},
            {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
            {0, 0, 1, 1, 2, 2, 1, 1, 3, 2},
            {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0}
    };
    static int percent[] = {1, 1, 7, 7, 10, 10, 2, 2, 5};

    static int[][] sand;
    static int answer;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sand = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                sand[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int r, c;
        r = N / 2;
        c = N / 2;

        int moveCount = 1;
        int dir = 0;

        while(true){
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < moveCount; j++){
                    spreadSand(r, c, dir);
                    r += dr[dir];
                    c += dc[dir];
                }
                dir = (dir + 1) % 4;
            }
            moveCount++;

            if(moveCount == N){
                for(int i = 0; i < moveCount - 1; i++){
                    spreadSand(r, c, dir);
                    r += dr[dir];
                    c += dc[dir];
                }
                break;
            }
        }
        System.out.println(answer);
    }
    private static void spreadSand(int r, int c, int dir){
        int nr = r + dr[dir];
        int nc = c + dc[dir];
        int cur = sand[nr][nc];

        for(int i = 0; i < 9; i++){
            int nnr = r + spreadR[dir][i];
            int nnc = c + spreadC[dir][i];

            int plus = cur * percent[i] / 100;

            if(nnr < 0 || nnr >= N || nnc < 0 || nnc >= N){
                answer += plus;
            }else{
                sand[nnr][nnc] += plus;
            }
            sand[nr][nc] -= plus;
        }

        int ar = r + spreadR[dir][9];
        int ac = c + spreadC[dir][9];
        if(ar < 0 || ar >= N || ac < 0 || ac >= N){
            answer += sand[nr][nc];
        }else{
            sand[ar][ac] += sand[nr][nc];
        }
        sand[nr][nc] = 0;
    }
}