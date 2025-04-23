import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(set::add);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(num -> sb.append(set.contains(num) ? "1\n" : "0\n"));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}