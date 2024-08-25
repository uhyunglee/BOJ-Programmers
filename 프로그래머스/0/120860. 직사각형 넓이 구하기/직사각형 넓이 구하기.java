class Solution {
    public int solution(int[][] dots) {
        int width = Math.max(dots[0][0], dots[1][0]) - Math.min(dots[2][0], dots[3][0]);
        int height = Math.max(dots[0][1], dots[1][1]) - Math.min(dots[2][1], dots[3][1]);
        return Math.abs(width * height);
    }
}