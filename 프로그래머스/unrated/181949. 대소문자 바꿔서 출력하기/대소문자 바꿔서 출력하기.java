import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String answer = "";
        
        for(Character c : a.toCharArray()){
            if(Character.isUpperCase(c)){
                answer += Character.toLowerCase(c);
            }else
                answer += Character.toUpperCase(c);
        }
    System.out.println(answer);
    }
}