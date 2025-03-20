import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                for(int j = 0; j < p; j++){
                    sb.append(c);
                }
            }
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
    }
}