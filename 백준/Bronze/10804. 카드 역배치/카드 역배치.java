import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        // NOTE: list에 입력
        for(int i = 0; i <= 20; i+=1){
            list.add(i);
        }

        for(int i = 0; i < 10; i+=1){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = end- start;
            for(int j = 0; j < cnt; j+=1){
                list.add(start++, list.get(end)); // 중간에 값 삽입 한칸씩 밀려남
                list.remove(end + 1); // 밀려난 값 삭제
            }
        }

        for(int i = 1; i < list.size(); i+=1){
            bw.write(list.get(i) + " ");
//            System.out.print(list.get(i) + " ");
        }
        bw.flush();
    }
}
