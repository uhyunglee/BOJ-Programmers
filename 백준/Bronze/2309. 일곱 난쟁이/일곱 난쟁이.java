import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        int nonMemA = 0;
        int nonMemB = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int nonMember = arr[i] + arr[j];
                if(sum - nonMember == 100){
                    nonMemA = arr[i];
                    nonMemB = arr[j];
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == nonMemA) continue;
            else if(arr[i] == nonMemB) continue;
            else System.out.println(arr[i]);
        }
    }
}
