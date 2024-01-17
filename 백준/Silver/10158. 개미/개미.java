import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int t = sc.nextInt();

        int currentX = (t + x) % (2 * w);
        int currentY = (t + y) % (2 * h);

        if(currentX > w) currentX = 2 * w - currentX;
        if(currentY > h) currentY = 2 * h - currentY;

        System.out.println(currentX + " " + currentY);
    }
}
