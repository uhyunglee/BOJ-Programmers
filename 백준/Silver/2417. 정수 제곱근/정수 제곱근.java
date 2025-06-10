// 시간복잡도: O(log N)
// 접근방법: 이분탐색 => 최적의 해
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.println(calcIntegerSqrt(n));
    }

    static long calcIntegerSqrt(long x){
        if(x == 0) return 0;

        long lo = 1, hi = 1L << 32, sqrt = -1;
        while(lo <= hi){
            long mid = (lo + hi) / 2;
            if(mid >= (x - 1) / mid + 1){
                hi = mid - 1;
                sqrt = mid;
            }else lo = mid + 1;
        }
        return sqrt;
    }
}