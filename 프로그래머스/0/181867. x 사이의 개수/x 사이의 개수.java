class Solution {
    public int[] solution(String myString) {
        String[] a = myString.split("x");
        int[] answer = myString.endsWith("x") ? new int[a.length + 1] : new int[a.length];
        System.out.println(a.length);
            
        for(int i=0; i < a.length; i++){
            answer[i] = a[i].length();
        }
        return answer;
    }
}