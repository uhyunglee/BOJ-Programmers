import java.io.*;
import java.util.*;

public class Main {
    static int s;
    static int[] numbers;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        solve(0, 0);
        System.out.println(answer);
    }

    static void solve(int index, int sum){
        // base condition
        if(index == numbers.length) return;
        if(sum + numbers[index] == s) answer++;

        // recursive condition
        solve(index + 1, sum);
        solve(index + 1, sum + numbers[index]);
    }
}