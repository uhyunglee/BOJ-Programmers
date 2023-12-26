import java.util.StringTokenizer;

class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        int count = st.countTokens();
        String[] answer = new String[count];
        for(int i = 0; i < count; i++){
            answer[i] = st.nextToken();
        }
        return answer;
    }
}