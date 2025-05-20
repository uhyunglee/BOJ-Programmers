// 접근방법: 완전탐색 -> 시간복잡도: O(100,000,000) 제한시간0.5초안에 불가능 => 투포인터로 접근
// 시간복잡도: O(n)

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while(true){
            if(sum > m){
                sum -= arr[left++];
            }else if(sum < m){
                sum += arr[right++];
            }else{
                count++;
                sum -= arr[left++];
            }
            if(sum < m && right == n)break;
        }

        System.out.println(count);
    }
}