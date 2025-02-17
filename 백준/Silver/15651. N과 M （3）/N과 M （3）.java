import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[9];

        solve(0);

        bw.flush();
        bw.close();
    }

    static void solve(int k) throws IOException {
        // NOTE : 종료 조건
        if(k == m){
            for(int i = 0; i < m; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
                arr[k] = i;
                solve(k + 1);
        }
    }
}