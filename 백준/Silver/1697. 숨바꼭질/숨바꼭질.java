import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] visited = new int[200001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == k) break;
            int[] dx = {cur - 1, cur + 1, cur * 2};
            for(int i = 0; i < 3; i++){
                if(!isRange(dx[i])) continue;
                if(visited[dx[i]] == 0){
                    visited[dx[i]] = visited[cur] + 1;
                    queue.add(dx[i]);
                }
            }
        }
        System.out.println(visited[k]);


    }
    static boolean isRange(int x){
        return x >= 0 && x <= 100000;
    }
}