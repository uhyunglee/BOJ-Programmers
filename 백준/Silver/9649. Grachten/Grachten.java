import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line;
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            int ab = Integer.parseInt(st.nextToken());
            int ac = Integer.parseInt(st.nextToken());
            int bd = Integer.parseInt(st.nextToken());
            int denominator = ab * ac;
            int fraction = bd - ac;
            int gcd = gcd(denominator, fraction);
            denominator /= gcd;
            fraction /= gcd;

            System.out.println(denominator + "/" + fraction);


        }
    }
    private static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

}