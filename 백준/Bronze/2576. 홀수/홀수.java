import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[7];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for(int num : arr){
            if(num % 2 == 1){
                if(num < min) min = num;
                sum += num;
            }
        }

        if(sum != 0){
            System.out.println(sum);
            System.out.println(min);
        }else {
            System.out.println(-1);
        }


    }
}