import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for(int i = 0; i < N; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);
        for(int i = 0; i < N / 2; i++){
            int temp = ropes[i];
            ropes[i] = ropes[N - i - 1];
            ropes[N - i - 1] = temp;
        }

        int maxWeight = 0;
        for(int i = 0; i < N; i++){
            int weight = ropes[i] * (i + 1);
            if(weight > maxWeight)
                maxWeight = weight;
        }
        System.out.println(maxWeight);
    }
}
