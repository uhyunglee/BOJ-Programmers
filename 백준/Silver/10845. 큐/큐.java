import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
class Main {
    static int N;
    static ArrayDeque<Integer> queue = new ArrayDeque<>();
    static void push(int x){
        queue.addFirst(x);
    }

    static int pop(){
        if(queue.isEmpty()) return -1;
        return queue.pollLast();
    }

    static int size(){
        return queue.size();
    }

    static int empty(){
        if(queue.isEmpty()) return 1;
        else return 0;
    }

    static int front(){
        if(queue.isEmpty()) return -1;
        return queue.peekLast();
    }
    static int back(){
        if(queue.isEmpty()) return -1;
        return queue.peekFirst();
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
                case "front":
                    bw.write(String.valueOf(front() + "\n"));
                    break;
                case "back":
                    bw.write(String.valueOf(back() + "\n"));
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}