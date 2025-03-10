class Solution {
    static int left = 10;
    static int right = 12;
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        for(int number : numbers){
            answer.append(pressKey(number, hand));
        }
        return answer.toString();
    }
    
    public String pressKey(int number, String hand){
        if(number == 1 || number == 4 || number == 7){ // 왼쪽열
            left = number;
            return "L";
        }else if(number == 3 || number == 6 || number == 9){ // 오른쪽열
            right = number;
            return "R";
        }else{// 가운데열
            if(number == 0) number = 11; // 예외처리
            int leftDis = (Math.abs(left - number) / 3) + (Math.abs(left - number) % 3);
            int rightDis = (Math.abs(right - number) / 3) + (Math.abs(right - number) % 3);
            if(leftDis < rightDis){
                left = number;
                return "L";
            }else if(leftDis > rightDis){
                right = number;
                return "R";
            }else{
                if(hand.equals("left")){
                    left = number;
                    return "L";
                }else{
                    right = number;
                    return "R";
                }
            }
        }
    }
}