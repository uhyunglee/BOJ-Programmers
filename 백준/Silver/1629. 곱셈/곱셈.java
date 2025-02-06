import java.util.*;
import java.io.*;


class Main {
        static long a;
        static long b;
        static long c;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        System.out.println(pow(a, b));
    }

    static long pow(long a, long b){
        if(b == 1) return a % c;

        long result = pow(a, b/2);
        result = result * result % c;

        if(b % 2 == 0) return result;

        return result * a % c;
    }
}
