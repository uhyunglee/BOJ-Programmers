class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 초 로 통일하기
        int videoLength = Integer.parseInt(video_len.substring(0,2)) * 60 + Integer.parseInt(video_len.substring(3));
        int position = Integer.parseInt(pos.substring(0,2)) * 60 + Integer.parseInt(pos.substring(3));
        int opStart = Integer.parseInt(op_start.substring(0,2)) * 60 + Integer.parseInt(op_start.substring(3));
        int opEnd = Integer.parseInt(op_end.substring(0,2)) * 60 + Integer.parseInt(op_end.substring(3));
        
         // 기능 1) prev:10초 전 이동 2) next:10초 후 이동  3) 오프닝 건너뛰기(오프닝 구간인 경우)
        for(int i = 0; i < commands.length; i++){
            position = isSkip(opStart, opEnd, position); // 오프닝 체크
            if(commands[i].equals("prev")){// 10초 전 이동
                position -= 10;
            }else if(commands[i].equals("next")){// 10초 후 이동
                position += 10;
            }
            position = isEnd(videoLength, position); // 이동 후 엣지케이스
            position = isSkip(opStart, opEnd, position); // 오프닝 체크
        }
        // 커맨드 대로 이동 후 오프닝 사이에 있으면 오프닝 끝나는 위치로 이동
        String mm = (position / 60) + "";
        String ss = (position % 60) + "";
        if(mm.length() == 1)
            mm = "0" + mm;
        if(ss.length() == 1)
            ss = "0" + ss;
            
        String answer = mm + ":" + ss;
        
        return answer;
    }
    
    public int isSkip(int opStart, int opEnd, int position){
        int skipOrNot = 0;
        if(position >= opStart && position <= opEnd){
            skipOrNot = opEnd;
        }else skipOrNot = position;
        
        return skipOrNot;
    }
    public int isEnd(int videoLength, int position){
        if(position < 0) position = 0;
        if(position > videoLength) position = videoLength;
        
        return position;
    }
}