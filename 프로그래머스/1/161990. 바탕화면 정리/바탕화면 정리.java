import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        // NOTE: 바탕화면 2차원 배열 선언
        int x = wallpaper.length; 
        int y = wallpaper[0].length();
        String[][] screen = new String[x][y];
        
        // NOTE: 바탕화면 입력
        for(int i = 0; i < x; i++){
            screen[i] = wallpaper[i].split("");
        }
        
        // NOTE: 완전탐색
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE; // 처음 세로, 처음 가로
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE; // 마지막 세로, 마지막 가로
        
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(screen[i][j].equals("#")){
                    if(lux > i) lux = i;
                    if(luy > j) luy = j;
                    if(rdx < i) rdx = i;
                    if(rdy < j) rdy = j;
                }
            }
        }
        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx + 1;
        answer[3] = rdy + 1;
        
        
        return answer;
    }
}