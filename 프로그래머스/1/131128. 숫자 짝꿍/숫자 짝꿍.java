import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        StringBuilder answer = new StringBuilder();
        
        StringBuilder sb = new StringBuilder(X);
        for(int i = 0; i < X.length(); i++){
            arr1[sb.charAt(i) - '0']++;
        }
        sb = new StringBuilder(Y);
        for(int i = 0; i < Y.length(); i++){
            arr2[sb.charAt(i) - '0']++;
        }
        
        for(int i = 9; i >= 0; i--){
            while(arr1[i] > 0 && arr2[i] > 0){
                answer.append(i);
                arr1[i]--;
                arr2[i]--;
            }
        }
        
      	if("".equals(answer.toString())) return "-1";
        if("0".equals(answer.toString().substring(0,1))) return "0";
        
        return answer.toString();
    }
}