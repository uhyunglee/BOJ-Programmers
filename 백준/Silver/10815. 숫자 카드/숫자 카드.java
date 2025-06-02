import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] card = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] check = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] isOwned = new int[M];

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < card.length; i++){
            set.add(card[i]);
        }
        for(int i = 0; i < check.length; i++){
            map.put(check[i], i); // <숫자, 인덱스>
        }

        // 탐색 O(M)
        for(int i = 0; i < check.length; i++){
            if(set.contains(check[i])){
                isOwned[map.get(check[i])]++;
            }
        }
        for(int i = 0; i < M; i++){
            bw.write(isOwned[i] + " ");
        }
        bw.flush();
        bw.close();


    }
}