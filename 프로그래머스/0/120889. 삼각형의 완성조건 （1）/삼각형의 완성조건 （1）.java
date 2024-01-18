import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        
        if(sides[2] < sides[1] + sides[0])
            return 1;
        else return 2;
    }
}