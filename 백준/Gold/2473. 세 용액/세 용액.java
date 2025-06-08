// 시간복잡도 : O(N^2)
// 접근방법: 투포인터 + 고정
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long result = Long.MAX_VALUE;
        long num1 = 0, num2 = 0, num3 = 0;

        for(int i = 0; i < N - 2; i++){
            int left = i + 1;
            int right = N - 1;

            while(left < right){
                long sum = arr[i] + arr[left] + arr[right];

                if(Math.abs(sum) < result){
                    result = Math.abs(sum);
                    num1 = arr[i];
                    num2 = arr[left];
                    num3 = arr[right];
                }
                if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        System.out.println(num1 + " " + num2 + " " + num3);
    }
}