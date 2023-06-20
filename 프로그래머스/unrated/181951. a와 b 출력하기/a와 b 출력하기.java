import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        if((a>= -1000000 && a<=1000000) && (b>= -1000000 && b<= 1000000)){
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }
    }
}