import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    static boolean[][] map;
    static int min = 64;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];

        for(int i = 0; i < map.length; i++){
            String str = br.readLine();
            for(int j = 0; j < map[0].length; j++){
                if(str.charAt(j) == 'W')
                    map[i][j] = true;
            }
        }
        int row = n - 7;
        int col = m - 7;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                find(i,j);
            }
        }
        System.out.println(min);
    }

    private static void find(int r, int c){
        int rowEnd = r + 8;
        int colEnd = c + 8;
        int count = 0;

        boolean blackOrWhite = map[r][c];
        for(int i = r; i < rowEnd; i++){
            for(int j = c; j < colEnd; j++){
               if(map[i][j] != blackOrWhite){
                   count++;
               }
               blackOrWhite = !blackOrWhite;
            }
            blackOrWhite = !blackOrWhite;
        }
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}