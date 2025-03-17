import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i < 10; i++){
            System.out.println(n +" * " + i + " = " + n * i);
        }


    }
}