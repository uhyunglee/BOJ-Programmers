import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
        for(int i = 0; i < N; i++){
            buildings[i] = Integer.parseInt(br.readLine());
        }
        long tot = 0;

        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && stack.peek() <= buildings[i]){
                stack.pop();
            }
            tot += stack.size();
            stack.push(buildings[i]);
        }
        System.out.println(tot);
    }
}