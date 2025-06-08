
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int right = arr.length - 1;
        int result = Integer.MAX_VALUE;
        int num1 = 0, num2 = 0;
        while(left < right){
            int sum =  arr[left] + arr[right];
            if(Math.abs(sum) < result) {
                result = Math.min(result, Math.abs(sum));
                num1 = arr[left];
                num2 = arr[right];
            }else {
                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(num1 + " " + num2);
    }
}