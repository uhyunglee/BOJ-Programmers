import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] scores = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[i][0] = Integer.parseInt(st.nextToken());
                scores[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores, Comparator.comparingInt(a -> a[0]));

            int count = 1; 
            int bestInterview = scores[0][1]; 

            for (int i = 1; i < n; i++) {
                if (scores[i][1] < bestInterview) {
                    count++;
                    bestInterview = scores[i][1];
                }
            }

            System.out.println(count);
        }
    }
}