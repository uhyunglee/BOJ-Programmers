class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int mul = 1;
        for(int i=0; i<num_list.length; i++){
            mul *=num_list[i]; 
            sum += num_list[i];
        }
        
        return mul < sum * sum ? 1 : 0;
    }
}