import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();
            int floor = n % h;
            int roomNum = n / h + 1;
            if(floor == 0){
                floor = h;
                roomNum = n / h;
            }
            System.out.printf("%d%02d%n", floor, roomNum);
        }

    }
}