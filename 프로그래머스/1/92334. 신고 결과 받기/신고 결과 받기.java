import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        // 피신고자 / 신고자 목록
        Map<String, List<String>> reportLog = new HashMap<>();
        for(String set : reportSet){
            String[] person = set.split(" ");
            // 첫 신고 라면 빈 리스트 생성
            List<String> list = reportLog.getOrDefault(person[1], new ArrayList<>());
            // 신고자 목록에 삽입
            list.add(person[0]);
            // 피신고자 / 신고자 목록 삽입
            reportLog.put(person[1], list);
        }
        
        // 신고자 / 메일 수
        Map<String, Integer> mailCounts = new HashMap<>();
        for(Map.Entry<String, List<String>> log : reportLog.entrySet()){
            // 신고자 목록이 k 이상일 때 신고자 목록 처리
            if(log.getValue().size() >= k){
                for(String people : log.getValue()){
                    // 모든 신고자 + 1
                    mailCounts.put(people, mailCounts.getOrDefault(people, 0) + 1);
                }
            }
        }
        
        // 스트림 API로 입력 배열을 메일 카운트 맵과 매칭하여 정답구성 
        return Arrays.stream(id_list)
            .map(x -> mailCounts.getOrDefault(x, 0))
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}