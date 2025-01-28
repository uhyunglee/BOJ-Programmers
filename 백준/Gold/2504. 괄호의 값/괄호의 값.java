import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int value = 1;
        int answer = 0;

        char[] arr = br.readLine().toCharArray();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                stack.push(arr[i]);
                value *= 2;
            }else if(arr[i] == '['){
                stack.push(arr[i]);
                value *= 3;
            }else if(arr[i] == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    answer = 0;
                    break;
                }else if(arr[i - 1] == '('){
                    answer += value;
                }
                stack.pop();
                value /= 2;
            }else if(arr[i] == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    answer = 0;
                    break;
                }else if(arr[i - 1] == '['){
                    answer += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        if(!stack.isEmpty()) answer = 0;
        System.out.println(answer);
    }
}