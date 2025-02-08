import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        int result = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=start; i<=end; i++){
            if(i<2) continue;
            boolean prime = false;

            for(int j=2; j * j <=i; j++){
                if(i % j == 0){
                    prime = true;
                    break;
                }
            }
            if(prime) continue;
            list.add(i);
        }

        for(Integer num: list){
            result += num;
        }

        if(list.isEmpty()) {
            System.out.println(-1);
        }else{
            System.out.println(result);
            System.out.println(list.get(0));
        }


    }
}