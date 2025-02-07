import java.util.*;
import java.io.*;


class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        bw.write((1 << n) - 1 + "\n");
        hanoi(n, 1, 3);

        bw.flush();
        bw.close();
    }
    static private void hanoi(int n, int from, int to) throws IOException{
        if(n == 1){
            bw.write(from + " " + to + "\n");
            return;
        }

        int empty = 6 - from - to;

        hanoi(n-1, from, empty);
        bw.write(from + " " + to + "\n");
        hanoi(n-1, empty, to);
    }
}
