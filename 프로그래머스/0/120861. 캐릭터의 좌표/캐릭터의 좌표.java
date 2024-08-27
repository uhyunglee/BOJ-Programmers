class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int xCord = 0;
        int yCord = 0;
        
        for(String str : keyinput){
            if(str.equals("left")){
                xCord -= 1;
            }else if(str.equals("right")){
            	xCord += 1;   
            }else if(str.equals("up")){
                yCord += 1;
            }else if(str.equals("down")){
                yCord -= 1;
            }
            if(xCord > board[0] / 2){
                xCord = board[0] / 2;
            }else if(xCord < board[0] / 2 * -1){
                xCord = board[0] / 2 * -1;
            }
            if(yCord > board[1] / 2){
                yCord = board[1] / 2;
            }else if(yCord < board[1] / 2 * -1){
                yCord = board[1] / 2 * -1;
            }
        }
        
        int[] answer = {xCord, yCord};
        return answer;
    }
}