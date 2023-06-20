import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int aLength = a.length();
        
        if(aLength>=1 && aLength<=1000000){
            System.out.println(a);
        }
    }
}