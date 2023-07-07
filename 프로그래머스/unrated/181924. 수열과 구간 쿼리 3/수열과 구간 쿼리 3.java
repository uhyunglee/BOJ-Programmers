class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        
        /*for(int i=0; i<queries.length; i++){
            temp = arr[queries[i][0]];
            arr[queries[i][0]] = arr[queries[i][1]];
            arr[queries[i][1]] = temp;
            
        }*/
        for(int[] query : queries){
            int i = query[0];
            int j = query[1];
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}