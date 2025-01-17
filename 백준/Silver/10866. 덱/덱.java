import java.io.*;
import java.util.*;
class Main {
    static int N;
    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static void push_front(int x){
        deque.addLast(x);
    }
    static void push_back(int x){
        deque.addFirst(x);
    }

    static int pop_front(){
        if(deque.isEmpty()) return -1;
        return deque.pollLast();
    }
    static int pop_back(){
        if(deque.isEmpty()) return -1;
        return deque.pollFirst();
    }

    static int size(){
        return deque.size();
    }

    static int empty(){
        if(deque.isEmpty()) return 1;
        else return 0;
    }

    static int front(){
        if(deque.isEmpty()) return -1;
        return deque.peekLast();
    }
    static int back(){
        if(deque.isEmpty()) return -1;
        return deque.peekFirst();
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
                case "push_front":
                    int num = Integer.parseInt(st.nextToken());
                    push_front(num);
                    break;
                case "push_back":
                    int num2 = Integer.parseInt(st.nextToken());
                    push_back(num2);
                    break;
                case "pop_front":
                    bw.write(String.valueOf(pop_front() + "\n"));
                    break;
                case "pop_back":
                    bw.write(String.valueOf(pop_back() + "\n"));
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