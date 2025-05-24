import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashSet<Integer> set = new HashSet<>();
        long result = 0;
        int start = 0;
        for(int i = 0; i < n; i++){
            if(set.contains(arr[i])){
                for(int j = start; j < i; j++){
                    result += i - j;
                    start++;
                    if(arr[j] == arr[i]) break;
                    set.remove(arr[j]);
                }
            }else
                set.add(arr[i]);
        }
        for(int i = start; i < n; i++) {
            result += n - i;
        }
        System.out.println(result);
    }
}