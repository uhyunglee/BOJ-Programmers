import java.util.ArrayList;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(String intStr : intStrs){
            int strToInt = Integer.parseInt(intStr.substring(s, s+l));
            if(strToInt > k){
                list.add(strToInt);
            }else continue;
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}