class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        
        int[][] answer = new int[r1][c2];
        
        for(int row = 0; row < r1; row++){
            for(int col = 0; col < c2; col++){
                for(int i = 0; i < c1; i++){
                    answer[row][col] += arr1[row][i] * arr2[i][col];
                }
            }
        }
        return answer;
    }
}