import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] arr = new char[a.length()];
        
        for(int i = 0; i< a.length(); i++){
           arr[i] = a.charAt(i); 
        }
        for(int i = 0; i< a.length(); i++){
            System.out.println(arr[i]);
        }
    }
}