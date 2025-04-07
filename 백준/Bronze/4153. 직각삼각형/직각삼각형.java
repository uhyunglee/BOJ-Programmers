import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());
            if(num1 + num2 + num3 == 0) break;
            int[] arr = {num1, num2, num3};
            Arrays.sort(arr);

            System.out.println(isTriangle(arr[0], arr[1], arr[2]));
        }
    }
    static String isTriangle(int a, int b, int c){
        if(c * c == (a * a + b * b))
            return "right";
        return "wrong";
    }
}