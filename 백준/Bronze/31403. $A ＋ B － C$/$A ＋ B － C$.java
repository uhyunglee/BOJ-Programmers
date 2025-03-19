import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        String str = "";
        str += a;
        str += b;

        int d = Integer.parseInt(str);
        System.out.println(a + b - c);
        System.out.println(d - c);
    }
}