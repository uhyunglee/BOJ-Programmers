import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = numbers.length;
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(i != j){
                    int first = numbers[i];
                    int second = numbers[j];
                    list.add(first + second);
                }
            }
        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        Integer[] result = Arrays.stream(answer)
            .boxed()
            .distinct()
            .toArray(Integer[]::new);
        Arrays.sort(result);
        
        return Arrays.stream(result)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}