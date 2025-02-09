import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static int[] paper;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        paper = new int[3];

        // NOTE: 입력
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // NOTE:
        recursion(0, 0, n);
        for(int i = 0; i < 3; i++){
            System.out.println(paper[i]);
        }
    }

    // NOTE: 9분할로 나누는 재귀함수
    static void recursion(int x, int y, int length){
        if(isSame(x, y, length)){
            int color = board[x][y] + 1; // -1, 0, 1 -> 0, 1, 2
            paper[color]++;
            return;
        }
        int next = length / 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                recursion(x + next*i, y + next *j, next);
            }
        }
    }
     // NOTE: 같은색인지 확인하는 메서드
    static boolean isSame(int x, int y, int length){
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){ // 하나라도 다른색이 있으면 return
                if(board[x][y] != board[x + i][y + j]) return false;
            }
        }
        return true;
    }
}