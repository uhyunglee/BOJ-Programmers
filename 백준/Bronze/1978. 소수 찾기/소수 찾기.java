import java.nio.Buffer;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(num == 1) continue;
            boolean isPrime = true;
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0) isPrime = false;
            }
            if(isPrime) count++;
        }
        System.out.println(count);
    }
}
