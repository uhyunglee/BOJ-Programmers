import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] isUsed;

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[9];
        isUsed = new boolean[9];

        solve(0, 1);
    }
    static void solve(int k, int at){
        // NOTE : 종료 조건
        if(k == m){
            for(int i = 0; i < m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = at; i <= n; i++){
            if(!isUsed[i]){ // 탐색하지 않은 원소
                arr[k] = i;
                isUsed[i] = true;
                solve(k + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
}