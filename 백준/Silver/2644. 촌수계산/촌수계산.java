import java.io.*;
import java.util.*;

public class Main {
    static int n, m, start, end;
    static int[][] map;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        distance = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        // NOTE: map에 거리 기록
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            map[first][second] = map[second][first] = 1;
        }

        dfs(start);

        System.out.println(distance[end] == 0 ? -1 : distance[end]);

    }
    static void dfs(int index){
        if(index == end) return;

        for(int i = 1; i <= n; i++){
            if(map[index][i] == 1 && distance[i] == 0){
                distance[i] = distance[index] + 1;
                dfs(i);
            }
        }

    }
}