import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int t = sc.nextInt();

        int tx = t % (2 * w);
        int ty = t % (2 * h);
        int dx = 1;
        int dy = 1;
        while(tx-- > 0){
            if(x == w){
                dx = -1;
            }else if (x == 0){
                dx = 1;
            }
            x += dx;
        }

        while(ty-- > 0){
            if(y == h)
                dy = -1;
            else if(y == 0)
                dy = 1;
            y += dy;
        }
        System.out.println(x + " " + y);
    }
}
