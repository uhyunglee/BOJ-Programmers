import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 스택 배열 생성
        ArrayDeque<Integer>[] stack = new ArrayDeque[board.length];
        int countDolls = 0;
        
        for(int i = 0; i < board.length; i++){
            stack[i] = new ArrayDeque<>();
        }
        
        // 스택에 board 값 넣기
        for(int i = board.length - 1; i >= 0; i--){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] > 0)
                    stack[j].push(board[i][j]);
            }
        }
        
        ArrayDeque<Integer> slot = new ArrayDeque<>();
        
        // moves 순회하면서 stack에서 뽑아 바구니에 넣기 : O(M)
        for(int i = 0; i < moves.length; i++){
            if(!stack[moves[i] - 1].isEmpty()){
                int pick = stack[moves[i] - 1].pop();
                if(!slot.isEmpty() && slot.peek() == pick){
                    slot.pop();
                    countDolls += 2;
                }
                else
                    slot.push(pick);
            }
        }	
        
        return countDolls;
    }
}