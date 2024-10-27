import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        StringBuffer sb = new StringBuffer();
        
        String str = n + "";
        String[] arrStr = str.split("");
        
        Arrays.sort(arrStr);
        for(int i = arrStr.length-1; i >= 0; i-=1){
            sb.append(arrStr[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}