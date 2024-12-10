import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(br.readLine());
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += sb.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}