import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int length = numbers.length;
        Arrays.sort(numbers);
        int negativeMax = numbers[0] * numbers[1];
        int positiveMax = numbers[length - 1] * numbers[length - 2];
        
        return negativeMax > positiveMax ? negativeMax : positiveMax;
    }
}