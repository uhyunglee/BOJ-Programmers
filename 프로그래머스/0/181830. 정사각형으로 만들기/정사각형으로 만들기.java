import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] answer = {};
        if(n >= m){
            answer = new int[n][n];
            for(int i = 0; i < n; i++){
                answer[i] = Arrays.copyOf(arr[i], n);
            }
        }
        else{
            answer = new int[m][m];
            for(int i = 0; i < n; i++){
                answer[i] = Arrays.copyOf(arr[i], m);
            }
        }
        
        return answer;
    }
}