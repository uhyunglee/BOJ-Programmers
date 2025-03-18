import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        // 1 X : 정수 X 를 스택에 넣는다.
        // 2 : 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없으면 -1 을 출력한다.
        // 3 : 스택에 들어있는 정수의 개수를 출력한다.
        // 4 : 스택이 비어있으면 1 아니면 0을 출력한다.
        // 5 : 스택에 정수가 있다면 맨위의 정수를 출력한다. 없다면 -1을 대신 출력한다
        while(n-- > 0){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int methodNum = Integer.parseInt(st.nextToken());
            switch(methodNum){
                case 1:
                    int x = Integer.parseInt(st.nextToken());
                    firstMethod(x);
                    break;
                case 2:
                    bw.write(secondMethod() + "");
                    bw.write("\n");
                    break;
                case 3:
                    bw.write(thirdMethod() + "");
                    bw.write("\n");
                    break;
                case 4:
                    bw.write(fourthMethod() + "");
                    bw.write("\n");
                    break;
                case 5:
                    bw.write(fifthMethod() + "");
                    bw.write("\n");
                    break;
                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
    public static void firstMethod(int x){
        stack.addLast(x);
    }
    public static int secondMethod(){
        if(stack.isEmpty()){
            return -1;
        }
        return stack.pollLast();
    }
    public static int thirdMethod(){
        return stack.size();
    }
    public static int fourthMethod(){
        if(stack.isEmpty()){
            return 1;
        }else return 0;
    }
    public static int fifthMethod(){
        if(!stack.isEmpty()){
            return stack.peekLast();
        }else return -1;
    }
}