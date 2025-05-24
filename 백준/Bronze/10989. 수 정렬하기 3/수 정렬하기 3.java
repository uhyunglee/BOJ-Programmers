// 접근방법 계수정렬
// 시간복잡도 O(K) K : 10,001

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] cnt = new int[10001];
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            cnt[Integer.parseInt(br.readLine())]++;
        }
        for(int i = 0; i < 10001; i++){
            while(cnt[i]-- > 0){
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}