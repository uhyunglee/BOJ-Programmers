import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] num = new int[N];

        for(int i = 0; i < N; i++)
            num[i] = Integer.parseInt(br.readLine());

        for(int i = N-2; i >= 0; i--){
            if(num[i] >= num[i + 1]){
                answer += num[i] - (num[i + 1] - 1);
                num[i] = num[i + 1] - 1;
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}