import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n, 0));

    }

    static int[] queen = new int[15];
    static int solve(int n, int row){
        int count = 0;
        // base case
        if(row == n) return 1;

        //recursive case
        for(int col = 0; col < n; col++) {
            if(isValid(row, col)){
                queen[row] = col;
                count += solve(n, row + 1);
            }
        }
        return count;
    }

    static boolean isValid(int row, int col){
        for(int i = 0; i < row; i++){
            if(queen[i] == col) return false; // 같은 열에 다른 말이 존재
            if(Math.abs(row - i) == Math.abs(col - queen[i])) return false; // 대각선 상에 다른 말이 존재
        }
        return true;
    }
}