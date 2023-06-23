class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int numer3 = (numer1 * denom2) + (numer2 * denom1);
        int denom3 = denom1 * denom2;
        
        int i = 2;
        while(true){
            if((numer3 % i) == 0 && (denom3 % i) ==0 ){
                numer3 /= i;
                denom3 /= i;
            }else if((numer3 % i) != 0 || (denom3 % i) != 0){
                i++;
            }
            if(i > numer3 || i > denom3)
                break;
        }
        answer[0] = numer3;
        answer[1] = denom3;
        
        return answer;
    }
}