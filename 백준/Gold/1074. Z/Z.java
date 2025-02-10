import java.io.*;
import java.util.*;

public class Main {
    static int n, r, c;
    static int count = 0;
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        recursion(n, r, c);
        System.out.println(count);
    }
    static void recursion(int n, int r, int c){
        int boardSize = 1 << n; // 2^n
        int mid = boardSize / 2;
        if(n == 0) return;

        // 좌상
        if(r < mid && c < mid){
            recursion(n-1, r, c);
        }
        // 우상
        else if(r < mid && c >= mid){
            count +=  mid * mid;
            recursion(n-1, r, c - mid);
        }
        // 좌하
        else if(r >= mid && c < mid){
            count += mid * mid * 2;
            recursion(n-1, r - mid, c);
        }
        // 우하
        else if(r >= mid && c >= mid){
            count += mid * mid * 3;
            recursion(n-1, r - mid, c - mid);
        }
    }
}