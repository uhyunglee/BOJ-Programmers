import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(A * (B % 10));
        System.out.println(A * ((B / 10) % 10));
        System.out.println(A * (B / 100));
        System.out.println(A * B);
    }
}