import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        while(N-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(minheap.isEmpty()){
                    bw.write("0\n");
                }else{
                    bw.write(minheap.poll()+"\n");
                }
            }else{
                minheap.offer(num);
            }
        }

        bw.flush();
        bw.close();
    }
}
