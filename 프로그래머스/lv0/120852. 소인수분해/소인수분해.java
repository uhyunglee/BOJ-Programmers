import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        List<Integer> prime = new ArrayList<>();
        int count = 0;
        
        for(int i=2; i<=n; i++){
            if(n%i == 0){
                list.add(i);
            }            
        }
        
        for(int i=0; i<list.size(); i++){
            for(int j=2; j<=n; j++){
                if(list.get(i)%j == 0){
                    count += 1;
                }
            } 
            if(count == 1){
                prime.add(list.get(i));
            }
            count = 0;
        }
        
        int[] answer = new int[prime.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = prime.get(i);
        }
        return answer;
    }
}