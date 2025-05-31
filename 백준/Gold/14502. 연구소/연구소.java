import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static List<Point> walls, virus;
    static Queue<Point> q = new LinkedList<>();
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        walls = new ArrayList<>();
        virus = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0)
                    walls.add(new Point(i, j));
                if(board[i][j] == 2)
                    virus.add(new Point(i, j));
            }
        }

        safetyZone(board, 0, 0);
        bw.write(max + " ");
        bw.close();
    }
    static void safetyZone(int[][] board, int start, int count){
        if(count >= 3){
            int[][] tmpBoard;
            tmpBoard = expandVirus(board);
            int num = countSafetyZone(tmpBoard);
            if(max < num)
                max = num;
            return;
        }

        for(int i = start; i< walls.size(); i++){
            boolean[] check = new boolean[walls.size()];
            int[][] tmpBoard;
            Point p = walls.get(i);
            tmpBoard = deepCopy(board);
            tmpBoard[p.x][p.y] = 1;
            safetyZone(tmpBoard, i+1, count+1);
        }
    }

    static int[][] expandVirus(int[][] board){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        boolean[][] check = new boolean[N][M];

        for(int i = 0; i< virus.size(); i++){
            Point p = virus.get(i);
            q.offer(p);
            check[p.x][p.y] = true;
            while(!q.isEmpty()){
                p = q.poll();
                for(int j=0; j<4; j++){
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if(nx<0 || nx>=N || ny<0 || ny>=M)
                        continue;
                    if(board[nx][ny] == 1 || check[nx][ny])
                        continue;
                    board[nx][ny] = 2;
                    q.offer(new Point(nx, ny));
                    check[nx][ny] = true;

                }
            }
        }
        return board;
    }
    static int countSafetyZone(int[][] board){
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
    static int[][] deepCopy(int[][] arr){
        int[][] result = new int[arr.length][arr[0].length];
        for (int i=0; i<arr.length; i++) {
            result[i] = arr[i].clone();
        }
        return result;
    }
}
class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}