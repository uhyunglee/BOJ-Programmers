import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder(sc.next());
            for(int j = 0; j < n; j++){
                map[i][j] = sb.charAt(j) - '0';
            }
        }
        recursion(0, 0, n);

        bw.flush();
        bw.close();
    }

    // NOTE: 재귀 메서드
    static void recursion(int r, int c, int length) throws IOException{
        if(length == 0) return;
        if(isSame(r, c, length)){
            bw.write(map[r][c] + "");
            return;
        }
        int mid = length / 2;
        bw.write("(");
        recursion(r, c, mid);
        recursion(r , c + mid, mid);
        recursion(r + mid, c, mid);
        recursion(r + mid, c + mid, mid);
        bw.write(")");
    }

    // NOTE: 같은 값인지 확인하는 메서드
    static boolean isSame(int r, int c, int length){
        for(int i = 0; i < length; i++){ // (r, c) -> 시작 좌표
            for(int j = 0; j < length; j++){
                if(map[r][c] != map[r + i][c + j])return false;
            }
        }
        return true;
    }
}