import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }

        int cost = 0;
        while(list.size() != 1){
            int bigOne = list.get(0);
            sum -= bigOne;
            cost += (bigOne * sum);
            list.remove(0);
        }
        System.out.println(cost);

    }
}