import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int n = answers.length;
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        for(int i = 0; i < n; i++){
            if(student1[i % student1.length] == answers[i])
                cnt1++;
        }
        for(int i = 0; i < n; i++){
            if(student2[i % student2.length] == answers[i])
                cnt2++;
        }
        for(int i = 0; i < n; i++){
            if(student3[i % student3.length] == answers[i])
                cnt3++;
        }
        int[] scores = {cnt1, cnt2, cnt3};
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < scores.length; i++){
            if(scores[i] == maxScore)
                answer.add(i+1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}