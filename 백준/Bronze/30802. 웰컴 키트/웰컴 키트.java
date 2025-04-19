import java.nio.Buffer;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] shirts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = arr[0];
        int p = arr[1];

        int shirtBundle = 0;
        for(int i = 0; i < shirts.length; i++){
            if(shirts[i] % t == 0)
                shirtBundle += (shirts[i] / t);
            else shirtBundle += (shirts[i] / t) + 1;
        }
        int penBundle = n / p;
        int penCount = n % p;
        System.out.println(shirtBundle);
        System.out.println(penBundle + " " + penCount);


    }
}
