import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibo(n));

    }
    static long[] memo = new long[91];

    static long fibo(int n){
        if(n == 1 || n == 2) return 1;
        if(memo[n] != 0) return memo[n];
        memo[n] = fibo(n-1) + fibo(n-2);
        return memo[n];
    }
}