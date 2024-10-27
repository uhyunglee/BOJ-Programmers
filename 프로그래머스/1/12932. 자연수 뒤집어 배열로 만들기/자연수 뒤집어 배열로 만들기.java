class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        String[] arr = String.valueOf(n).split("");
        int[] reversed = new int[arr.length];
        
        for(int i = 0; i < arr.length; i+=1){
            reversed[i] = Integer.parseInt(arr[arr.length - 1 - i]);
        }
        
        return reversed;
    }
}