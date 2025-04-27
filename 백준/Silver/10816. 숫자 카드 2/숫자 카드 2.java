import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            num += 10000000;
            arr1[num]++;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            bw.write(arr1[num + 10000000] + " ");
        }
        bw.flush();
        bw.close();
    }
}
