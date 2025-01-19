import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] towers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] received = new int[n + 1];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && towers[stack.peek()] < towers[i]){
                stack.pop();
            }

            received[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        for(int i = 0; i < n; i++){
            bw.write(received[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}