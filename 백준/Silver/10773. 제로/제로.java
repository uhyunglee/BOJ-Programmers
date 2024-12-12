import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int k = sc.nextInt();
        int sum = 0;

        while(k-- > 0){
            int n = sc.nextInt();
            if(n == 0){
                stack.poll();
            }else stack.push(n);
        }
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}