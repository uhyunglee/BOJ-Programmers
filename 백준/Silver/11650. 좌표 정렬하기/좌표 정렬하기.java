import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            grid[i][0] = Integer.parseInt(st.nextToken());
            grid[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(grid, Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));
        StringBuilder sb = new StringBuilder();
        for(int[] point : grid){
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}