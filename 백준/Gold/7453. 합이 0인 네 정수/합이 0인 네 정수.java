// 시간복잡도: O(N^2) + O(N^2 log N^2)
// 접근방법: 정렬, 이분탐색(upper bound, lower bound)
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 4; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[] AB = new int [n * n];
        int[] CD = new int [n * n];

        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                AB[idx] = arr[i][0] + arr[j][1];
                CD[idx] = arr[i][2] + arr[j][3];
                idx++;
            }
        }
        Arrays.sort(CD);

        long answer = 0;
        for(int target : AB){
            int upper = upperBound(CD, -target);
            int lower = lowerBound(CD, - target);
            answer += (upper - lower);
        }
        System.out.println(answer);
    }
    static int upperBound(int[] arr, int target){
        int left = 0, right = arr.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    static int lowerBound(int[] arr, int target){
        int left = 0, right = arr.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}