// 시간복잡도: O(N)
// 접근방법: 해시
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < l; i++) {
            String s = br.readLine();
            map.put(s, i);
        }

        String[] arr = new String[l];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arr[entry.getValue()] = entry.getKey();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < l; i++) {
            if (arr[i] != null) {
                sb.append(arr[i] + "\n");
                k--;
            }
            if (k == 0) break;
        }
        System.out.println(sb);
    }
}