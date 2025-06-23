import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                String type = line[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for (int count : map.values()) {
                answer *= (count + 1); // 입거나 안 입거나
            }
            answer -= 1; // 알몸 제외
            System.out.println(answer);
        }
    }
}