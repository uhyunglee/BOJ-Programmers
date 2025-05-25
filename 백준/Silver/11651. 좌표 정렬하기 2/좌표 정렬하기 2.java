// 접근방법: y좌표 값을 첫번쩨 배열에 입력 후 정렬
// 시간복잡도 O(NlogN) : Arrays.sort

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            grid[i][1] = Integer.parseInt(st.nextToken());
            grid[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(grid, (e1, e2) ->{
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            }else{
                return e1[0] - e2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(grid[i][1]).append(" ").append(grid[i][0]).append("\n");
        }
        System.out.println(sb);
    }
}