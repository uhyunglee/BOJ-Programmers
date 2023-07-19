class Solution {
    public String solution(String myString, int[][] queries) {
        StringBuffer sb = new StringBuffer(myString);
        
        for(int[] query : queries){
            int s = query[0], e = query[1];
            StringBuffer q = new StringBuffer(sb.substring(s, e+1));
            q.reverse();
            sb.replace(s, e+1, q.toString());
        }
        
        return sb.toString();
    }
}