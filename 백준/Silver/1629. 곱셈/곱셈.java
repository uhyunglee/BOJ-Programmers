import java.util.*;
import java.io.*;


class Main {
    static long A;
    static long B;
    static long C;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();

        System.out.println(recursion(A, B));
    }

    static long recursion(long a, long b) {
        if (b == 1)
            return a % C;

        long k = recursion(a, b / 2);

        if (b % 2 == 1) {
            return (k * k % C) * A % C;
        }
        return k * k % C;
    }
}
