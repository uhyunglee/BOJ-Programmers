class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        int temp1 = 0;
        int temp2 = 0;
        
        for(int i=0; i<queries.length; i++){
            temp1 = arr[queries[i][0]];
            arr[queries[i][0]] = arr[queries[i][1]];
            arr[queries[i][1]] = temp1;
            
        }
        return arr;
    }
}