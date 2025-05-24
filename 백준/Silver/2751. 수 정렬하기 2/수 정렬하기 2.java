// 시간복잡도 O(n)
// 접근방법 n <= 1,000,000 이므로 출력때 BufferedWriter 사용

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}