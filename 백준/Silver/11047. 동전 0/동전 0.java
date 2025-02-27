import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        int[] wallet = new int[n];
        for(int i = 0; i < wallet.length; i++){
            wallet[i] = Integer.parseInt(br.readLine());
        }
        for(int i = wallet.length - 1; i >= 0; i--){
            while(wallet[i] <= k){
                k -= wallet[i];
                count++;
            }
        }
        System.out.println(count);
    }
}