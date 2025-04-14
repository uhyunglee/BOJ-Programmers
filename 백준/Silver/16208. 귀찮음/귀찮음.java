import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        List<Integer> list = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        long[] suffixSum = new long[n];
        suffixSum[n - 1] = 0;

        for(int i = n - 2; i >= 0; i--){
            suffixSum[i] = suffixSum[i + 1] + list.get(i + 1);
        }
        long cost = 0;
        for(int i = 0; i < n - 1; i++){
            cost += (long) list.get(i) * suffixSum[i];
        }
        System.out.println(cost);
    }
}