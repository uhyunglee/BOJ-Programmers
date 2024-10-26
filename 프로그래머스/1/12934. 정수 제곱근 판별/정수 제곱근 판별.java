class Solution {
    public long solution(long n) {
        long answer = 0;
        if(Math.pow((int)Math.sqrt(n), 2) == n){
            return (long)Math.pow(Math.sqrt(n) + 1 , 2);
        }else return -1;
    }
}