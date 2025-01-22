import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    	int[] students = new int[n+2];
        int possible = 0;
        for(int i : lost){
            students[i]--;
        }
        for(int i : reserve){
            students[i]++;
        }
        for(int i = 1; i <= n; i++){
            if(students[i] < 0 && students[i-1] >= 1){
                students[i] += 1;
                students[i-1] -= 1;
            }
            if(students[i] < 0 && students[i+1] >= 1){
                students[i] += 1;
                students[i+1] -= 1;
            }
        }
        for(int i = 1; i <= n; i++){
            if(students[i] >= 0) possible++;
        }
        return possible;
    }
}