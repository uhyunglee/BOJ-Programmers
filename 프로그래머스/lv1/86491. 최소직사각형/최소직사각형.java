import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int temp = 0;
        int[] a = new int[sizes.length];
        int[] b = new int[sizes.length];
        
        for(int i = 0; i< sizes.length; i++){
            int w = sizes[i][0], h = sizes[i][1];
            if(w < h){
                temp = w;
                w = h;
                h = temp;
            }
            a[i] = w;
            b[i] = h;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        
        answer = a[a.length-1] * b[b.length-1];
        
        return answer;
    }
}