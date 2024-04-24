import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 1 스테이지별 도전자 수를 구함
        int[] challenger = new int[N+2];
        for(int i = 0; i < stages.length; i++){
            challenger[stages[i]] += 1;
        }
        // 2 스테이지 별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        // 3 각 스테이지를 순회하며 실패율 계산
        for(int i = 1; i <= N; i++){
            if(challenger[i] == 0){// 4 도전한 사람 없는 경우, 실패율 0	
                fails.put(i, 0.0);
            }else{
                fails.put(i, challenger[i] / total); // 5 실패율
                total -= challenger[i]; // 6 다음 스테이지 실패율 구하기 위한 현재 스테이지의 인원을 뺌
            }
        }
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}