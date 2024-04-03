
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int x = Integer.parseInt(br.readLine());
        int left = 0;
        int right = nums.length-1;
        int count = 0;

        while(left < right){
            if(nums[left] + nums[right] < x)
                left+=1;
            else if(nums[left] + nums[right] > x)
                right-=1;
            else {
                count++;
                left+=1;
            }
        }
        System.out.println(count);
    }
}
