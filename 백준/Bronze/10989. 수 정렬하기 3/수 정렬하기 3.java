import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];

        for(int i = 0; i < N; i++){
            cnt[Integer.parseInt(br.readLine())]++;
        }
        // 출력
        for(int i = 0; i < 10001; i++){
            while(cnt[i]-- > 0){
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}
