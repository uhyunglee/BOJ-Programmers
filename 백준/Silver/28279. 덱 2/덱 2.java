import com.sun.jdi.IntegerType;

import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            switch(num){
                case 1:
                    first(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    second(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    bw.write(third() + "");
                    bw.write("\n");
                    break;
                case 4:
                    bw.write(fourth() + "");
                    bw.write("\n");
                    break;
                case 5:
                    bw.write(fifth() + "");
                    bw.write("\n");
                    break;
                case 6:
                    bw.write(sixth() + "");
                    bw.write("\n");
                    break;
                case 7:
                    bw.write(seventh() + "");
                    bw.write("\n");
                    break;
                case 8:
                    bw.write(eightth() + "");
                    bw.write("\n");
                    break;
                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
    private static void first(int x){
        deque.addFirst(x);
    }
    private static void second(int x){
        deque.addLast(x);
    }
    private static int third(){
        if(deque.isEmpty()) return -1;
        return deque.pollFirst();
    }
    private static int fourth(){
        if(deque.isEmpty()) return -1;
        return deque.pollLast();
    }
    private static int fifth(){
        return deque.size();
    }
    private static int sixth(){
        return deque.isEmpty() ? 1: 0;
    }
    private static int seventh(){
        if(!deque.isEmpty())
            return deque.peekFirst();
        else return -1;
    }
    private static int eightth(){
        if(!deque.isEmpty())
            return deque.peekLast();
        else return -1;
    }
}