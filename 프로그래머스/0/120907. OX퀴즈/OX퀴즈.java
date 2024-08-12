import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int i = 0;
        for(String str : quiz){
            StringTokenizer st = new StringTokenizer(str);
            int X = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int Y = Integer.parseInt(st.nextToken());
            String eq = st.nextToken();
            int Z = Integer.parseInt(st.nextToken());
            if(op.equals("+"))
                if(X + Y == Z)
                    answer[i] = "O";
            	else
                    answer[i] = "X";
            else
                if(X - Y == Z)
                    answer[i] = "O";
            	else
                    answer[i] = "X";
            i++;
        }
        return answer;
    }
}