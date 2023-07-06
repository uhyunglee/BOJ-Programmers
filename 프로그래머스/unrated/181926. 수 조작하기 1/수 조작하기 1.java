class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        for(char c : control.toCharArray()){
         	switch(c){
                case 'w':
                    n += 1;continue;
                case 's':
                    n -= 1;continue;
                case 'd':
                    n += 10;continue;
                case 'a':
                    n -= 10;continue;
            }  
        }
        return n;
    }
}