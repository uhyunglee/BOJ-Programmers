import java.util.*;
import java.io.*;

public class Main{
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[9];

        backtracking(0, 1);
    }
    private static void backtracking(int k, int at){
        // NOTE: 종료조건
        if(k == m){
            for(int i = 0; i < m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = at; i <= n; i++){
            arr[k] = i;
            backtracking(k + 1, i);
        }
    }
}