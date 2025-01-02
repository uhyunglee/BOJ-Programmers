import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] fib = new long[91];
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;
        // NOTE: 점화식 작성
        for(int i = 2; i < fib.length; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        System.out.println(fib[n]);

    }
}