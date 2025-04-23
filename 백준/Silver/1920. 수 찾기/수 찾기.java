import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(arr1[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i = 0; i < m; i++){
            if(set.contains(arr2[i])){
                bw.write("1" + "\n");
            }else
                bw.write("0" + "\n");
        }
        bw.flush();
        bw.close();
    }
}