import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] P = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();

        int sum = 0;
        int answer = 0;
        for(int i = 0; i < n; i++){
            sum += P[i];
            answer += sum;
        }
        System.out.println(answer);
    }
}