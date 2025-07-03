

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N * N];

        for(int i = 0; i < N; i++){
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for(int j = 0; j < N; j++){
                arr[i * N + j] = line[j];
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length - N]);
    }
}