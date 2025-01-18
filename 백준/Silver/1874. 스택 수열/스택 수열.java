import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];

        int idx = 0;
        int pointer = 0;

        while(n-- > 0){
            int element = Integer.parseInt(br.readLine());
            if(element > pointer){
                for(int i = pointer + 1; i <= element; i++){
                    stack[idx] = i;
                    idx++;
                    sb.append("+\n");
                }
                pointer = element;
            }else if(stack[idx - 1] != element){
                System.out.println("NO");
                return;
            }
            idx--;
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}