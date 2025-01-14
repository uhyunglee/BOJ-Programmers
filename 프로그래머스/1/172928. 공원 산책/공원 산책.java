import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 시뮬레이션 
        StringTokenizer st;
        String[][] map = new String[park.length][park[0].length()];
        int height = map.length;
        int width = map[0].length;
        // NOTE: 위치 초기화
        int posX = -1;
        int posY = -1;
        
        // NOTE: 주어진 park 배열을 2차원 배열로 전환 && 시작점 찾기(S)
        for(int i = 0; i < map.length; i++){
            map[i] = park[i].split("");
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j].equals("S")){
                    posX = i;
                    posY = j;
                }
            }
        }
        
        
        // NOTE: 경로 실행 (장애물 있으면 명령 취소 || 경계밖으로도 나가면 취소)
        for(int i = 0; i < routes.length; i++){
            st = new StringTokenizer(routes[i]);
            String direction = st.nextToken();
            int space = Integer.parseInt(st.nextToken());
        	boolean obstacle = false;
            
            if(direction.equals("N")){
                
                if(posX - space < 0) continue;
                
                for(int j = 1; j <= space; j++){
                    if(map[posX - j][posY].equals("X")){
                        obstacle = true;
                        break;
                    }
                }
                if(!obstacle) posX -= space;
                
            }else if(direction.equals("S")){
                
                if(posX + space >= height) continue;
                
                for(int j = 1; j <= space; j++){
                    if(map[posX + j][posY].equals("X")){
                        obstacle = true;
                        break;
                    }
                }
                if(!obstacle) posX += space;
                
            }else if(direction.equals("W")){
                
                if(posY - space < 0) continue;
                
                for(int j = 1; j <= space; j++){
                    if(map[posX][posY - j].equals("X")){
                        obstacle = true;
                        break;
                    }
                }
                if(!obstacle) posY -= space;
                
            }else if(direction.equals("E")){
                
                if(posY + space >= width) continue;
                
                for(int j = 1; j <= space; j++){
                    if(map[posX][posY + j].equals("X")){
                        obstacle = true;
                        break;
                    }
                }
                if(!obstacle) posY += space;
                
            }
        }
        
        int[] answer = {posX, posY};
        
        return answer;
    }
}