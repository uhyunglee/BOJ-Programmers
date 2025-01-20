import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean isRight = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringBuilder command = new StringBuilder(br.readLine());
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            StringBuilder number = new StringBuilder();

            // NOTE: 명령어 입력
            for (char c : br.readLine().toCharArray()) {
                if (Character.isDigit(c)) {
                    number.append(c);
                } else if (number.length() > 0) { // delimeter
                    deque.add(Integer.parseInt(number.toString()));
                    number.setLength(0);
                }
            }
            if (number.length() > 0) {
                deque.add(Integer.parseInt(number.toString()));
            }
            AC(command, deque);
        }
        System.out.println(sb);
    }
    public static void AC(StringBuilder command, Deque<Integer> deque){
        isRight = true;
        // NOTE: command 실행
        for(char cmd : command.toString().toCharArray()){
            if(cmd == 'R'){
                isRight = !isRight;
                continue;
            }
            if(isRight){ // D && isRight == true
                if(deque.isEmpty()){
                    sb.append("error\n");
                    return;
                }
                deque.pollFirst();

            }else{ // D && isRight == false
                if(deque.isEmpty()){
                    sb.append("error\n");
                    return;
                }
                deque.pollLast();
            }
        }
        makePrint(deque, isRight);
    }
    public static void makePrint(Deque<Integer> deque, boolean isRight){
        sb.append("[");
        if(!deque.isEmpty()) {
            if (isRight) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append("]\n");
    }
}