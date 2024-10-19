import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int result = 0;
        ArrayDeque<Integer>[] stack = new ArrayDeque[board.length];
        
        for(int i = 0; i < board.length; i++){
            stack[i] = new ArrayDeque<>();
        }
        
        // board값 넣기
        for(int j = 0; j < board.length; j++){
            for(int i = board.length - 1; i >= 0; i--){
                if(board[i][j] > 0) stack[j].push(board[i][j]);
            }
        }
        
        // moves 순회
        ArrayDeque<Integer> slot = new ArrayDeque<>();
        for(int move : moves){
            if(!stack[move - 1].isEmpty()){
                int pick = stack[move - 1].pop();
                if(!slot.isEmpty() && slot.peek() == pick){
                    slot.pop();
                    result += 2;
                }else slot.push(pick);
            }
        }
        
        return result;
    }
}