import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int sum = 0;
        Arrays.sort(score);
        int n = score.length;
        int numOfBox = n / m; // 만들어질 상자의 수
        for(int i = n - m; i >= 0; i-=m){
            int maxProfit = 0;
            maxProfit = score[i] * m;
            sum += maxProfit;
        }
        return sum;
    }
}