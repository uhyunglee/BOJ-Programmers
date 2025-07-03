import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        int count = 0;
        while(N-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(minheap.size() == 0 && num == 0){
                bw.write("0\n");
            }else if(num == 0){
                bw.write(minheap.poll() + "\n");
            }else{
                minheap.add(num);
            }

        }

        bw.flush();
        bw.close();
    }
}
