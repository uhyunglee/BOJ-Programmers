import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String newStr = "";

        for(int i=0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c + 0 >= 65 && c + 0 < 92){
                c = (char)(c + 32);
//                newStr += c;
                newStr += Character.toString(c);
            }else if(c + 0 >= 97 && c + 0 <= 123){
                c = (char)(c - 32);
//                newStr  += c;
                newStr += Character.toString(c);
            }
        }
        System.out.println(newStr);
    }
}