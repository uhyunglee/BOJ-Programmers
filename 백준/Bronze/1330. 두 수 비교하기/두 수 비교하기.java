import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b= sc.nextInt();

        if(a > b) System.out.print(">");
        else if(a < b) System.out.print("<");
        else System.out.print("==");
    }
}