import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 

        int[] board = new int[101];
        boolean[] visited = new boolean[101];
        int[] moves = new int[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == 100) {
                System.out.println(moves[current]);
                return;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = current + dice;

                if (next > 100 || visited[next]) continue;

                int destination = (board[next] > 0) ? board[next] : next;

                if (!visited[destination]) {
                    visited[destination] = true;
                    moves[destination] = moves[current] + 1;
                    queue.offer(destination);
                }
            }
        }
    }
}