class Solution {
    public String[] solution(String[] names) {
        int group = names.length % 5 == 0 ? names.length / 5 : names.length / 5 + 1;
        String[] answer = new String[group];
        
        int j = 0;
        for(int i = 0; i < names.length; i+=5){
            answer[j] = names[i];
            j++;
        }
        
        
        return answer;
    }
}