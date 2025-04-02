import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = IntStream.range(0, n).boxed().map(i -> i + 1).collect(Collectors.toList());

        int idx = 0;
        bw.write("<");
        while(list.size() > 1){
            idx = (idx + k - 1) % list.size();
            bw.write(list.remove(idx) + ", ");
        }
        bw.write(list.get(0) + ">");
        bw.flush();
        bw.close();



    }
}