class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 0;
        // 제한수치 > 공격력
        
        for(int i = 1; i <= number; i++){
            int count = 0;
            // 약수의 개수
            for(int j = 1; j*j <= i; j++){
                if(j * j == i) count++;
                else if(i % j == 0) count += 2;
            }
            if(count > limit) count = power;
            sum += count;
        }
        return sum;
    }
}