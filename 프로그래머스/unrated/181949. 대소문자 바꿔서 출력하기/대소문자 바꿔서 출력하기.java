import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] b = a.toCharArray(); 
        String c = "";
        for(int i = 0; i < a.length(); i++){
            if((int)b[i] >= 90)
                b[i] = (char)((int)b[i] - 32);
            else
                b[i] = (char)((int)b[i] + 32);
		}
        for(int i = 0; i < a.length(); i++){
            System.out.print(b[i] + "");
        }
    }
}