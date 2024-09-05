class Solution {
    public String solution(String polynomial) {
        String[] equation = polynomial.split(" ");
        int coefficient = 0;
        int constant = 0;
        
        for(int i = 0; i < equation.length; i+=2){
            if(equation[i].contains("x")){
                if(equation[i].length() == 1)
                    coefficient += 1;
                else if(equation[i].length() == 2)
                    coefficient += Character.getNumericValue(equation[i].charAt(0));
                else
	                coefficient += Integer.parseInt(equation[i].substring(0, equation[i].length() - 1 ));
            }else{
                constant += Integer.parseInt(equation[i]);
            }
            
        }
        String answer = "";
        if(coefficient > 1 && constant == 0)
            answer = coefficient + "x";
        else if(coefficient == 1 && constant == 0)
            answer = "x";
        else if(coefficient == 1 && constant > 0)
            answer = "x" + " + " + constant;
        else if(coefficient == 0 && constant > 0)
            answer += constant;
        else
            answer = coefficient + "x" + " + " + constant;
        
        return answer;
    }
}