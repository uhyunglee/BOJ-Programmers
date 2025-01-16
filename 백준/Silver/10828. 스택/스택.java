import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
class Main {
    static int N;
    static List<Integer> stack = new ArrayList<>();
    static void push(int n){
        stack.add(n);
    }

    static int pop(){
        if(stack.isEmpty()) return -1;
        int num = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);

        return num;
    }

    static int size(){
        return stack.size();
    }

    static int empty(){
        if(stack.isEmpty()) return 1;
        else return 0;
    }

    static int top(){
        if(stack.isEmpty()) return -1;
        return stack.get(stack.size()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            String arr = st.nextToken();
            switch(arr){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                    bw.write(String.valueOf(pop() + "\n"));
                    break;
                case "size":
                    bw.write(String.valueOf(size() + "\n"));
                    break;
                case "empty":
                    bw.write(String.valueOf(empty() + "\n"));
                    break;
                case "top":
                    bw.write(String.valueOf(top() + "\n"));
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}