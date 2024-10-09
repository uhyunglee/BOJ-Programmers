class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};
        String[] repeat = {"ayaaya", "yeye", "woowoo", "mama"};
        // 반복 옹알 예외처리
        for(int i = 0; i < babbling.length; i++){
            for(int j = 0; j < 4; j++){
                babbling[i] = babbling[i].replace(repeat[j], "X");
                babbling[i] = babbling[i].replace(word[j], " ");
            }
            if(babbling[i].trim().length() == 0) answer++;
        }
        return answer;
    }
}