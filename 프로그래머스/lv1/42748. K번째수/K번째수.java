import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];
        
        for(int i=0; i<length; i++){
            //int[] newArray = new int[commands[i][1] - commands[i][0] + 1];
            int[] newArray = IntStream.range(commands[i][0] - 1, commands[i][1])
                .map(n -> array[n])
                .sorted()
                .toArray();
            answer[i] = newArray[commands[i][2] - 1];
        }
        
        
        return answer;
    }
}