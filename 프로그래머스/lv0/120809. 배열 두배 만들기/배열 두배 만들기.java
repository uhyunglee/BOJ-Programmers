class Solution {
    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            answer[i] = nums[i]*2;
        }
        return answer;
    }
}