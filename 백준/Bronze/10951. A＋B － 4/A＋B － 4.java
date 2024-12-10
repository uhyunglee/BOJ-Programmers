import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";

        while((str = br.readLine()) != null){
            int[] arr = Arrays.stream(str.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int A = arr[0];
            int B = arr[1];
            System.out.println(A + B);
        }
    }
}