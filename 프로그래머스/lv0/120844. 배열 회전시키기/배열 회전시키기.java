class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int temp = 0;
        
        if(direction.equals("right")){
            temp = numbers[numbers.length - 1];
            for(int i = 0; i< numbers.length; i++){
                answer[(i+1) % numbers.length] = numbers[i % numbers.length];
            }
            answer[0] = temp;
        }else if(direction.equals("left")){
            temp = numbers[0];
            for(int i = 0; i < numbers.length; i++){
                answer[i % numbers.length] = numbers[(i+1) % numbers.length];
            }
            answer[numbers.length - 1] = temp;
        }
        return answer;
    }
}