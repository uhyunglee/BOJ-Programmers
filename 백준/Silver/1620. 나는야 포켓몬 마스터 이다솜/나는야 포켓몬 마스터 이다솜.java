import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());

       Map<String, Integer> map1 = new HashMap<>();
       Map<Integer,String> map2 = new HashMap<>();
       int i = 1;
       while(n-- > 0){
           String str = br.readLine();
           map1.put(str, i);
           map2.put(i, str);
           i++;
       }
       // NOTE: 숫자인지 문자열인지 구분
       while(m-- > 0) {
           String str = br.readLine();
           if(Character.isDigit((str.charAt(0)))){
               int num = Integer.parseInt(str);
               bw.write(map2.get(num) + "\n");
           }else{
                bw.write(map1.get(str) + "\n");
           }
       }
       bw.flush();
       bw.close();
    }
}