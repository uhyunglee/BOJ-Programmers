import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while(n-- > 0){
            char[] arr = br.readLine().toCharArray();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for(int i = 0; i < arr.length; i++){
                if(stack.isEmpty()){
                    stack.push(arr[i]);
                    continue;
                }
                if(stack.peek() == '(' && arr[i] == ')'){
                    stack.pop();
                }else{
                    stack.push(arr[i]);
                }
            }
            if(stack.isEmpty()){
                System.out.println("YES");
            }else System.out.println("NO");
        }
    }
}