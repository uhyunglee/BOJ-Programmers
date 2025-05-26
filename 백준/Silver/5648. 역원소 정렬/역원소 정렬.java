// 시간복잡도 : O(nlogn)

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Long> list = new ArrayList<>();
        StringTokenizer st;
        String line = "";
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            while(st.hasMoreTokens()){
                String num = st.nextToken();
                list.add(reverseNum(num));
            }
        }
        if(!list.isEmpty()) list.remove(0);
        list.sort(null);
        for(int i = 0; i < list.size(); i++){
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }
    static long reverseNum(String n){
        StringBuilder sb = new StringBuilder(n);
        sb.reverse();
        return Long.parseLong(sb.toString());
    }
}