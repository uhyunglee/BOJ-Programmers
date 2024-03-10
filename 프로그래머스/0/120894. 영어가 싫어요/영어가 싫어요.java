class Solution { 
    public long solution(String numbers) {
        String str = "";
        String numStr = "";
        
        for(int i = 0; i < numbers.length(); i++){
            str += numbers.charAt(i);
            if(str.endsWith("one"))
                numStr += 1;
            else if(str.endsWith("two"))
                numStr+= 2;
            else if(str.endsWith("three"))
                numStr+= 3;
            else if(str.endsWith("four"))
                numStr+= 4;
            else if(str.endsWith("five"))
                numStr+= 5;
            else if(str.endsWith("six"))
                numStr+= 6;
            else if(str.endsWith("seven"))
                numStr+= 7;
            else if(str.endsWith("eight"))
                numStr+= 8;
            else if(str.endsWith("nine"))
                numStr+= 9;
            else if(str.endsWith("zero"))
                numStr+= 0;
        }
        
        return Long.parseLong(numStr);
    }
}