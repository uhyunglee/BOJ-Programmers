import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();

        int total = h * 60 + m;
        int time = total - 45;
        if(time < 0){
            time = 24 * 60 + time;
        }

        System.out.println(time / 60 + " " + time % 60);
    }
}