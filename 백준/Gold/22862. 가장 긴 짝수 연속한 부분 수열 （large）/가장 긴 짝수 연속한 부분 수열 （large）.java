// 시간복잡도: O(N)
// 접근방법: 투포인터
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondLine[i]); 
        }
        System.out.println(solve(arr, k));
    }

    private static int solve(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = 0;
        int oddCount = 0; 
        int maxLength = 0;

        while (right < n) {
            if (arr[right] % 2 == 1) {
                oddCount++;
            }
            while (oddCount > k) {
                if (arr[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1 - oddCount);
            right++;
        }
        return maxLength;
    }
}