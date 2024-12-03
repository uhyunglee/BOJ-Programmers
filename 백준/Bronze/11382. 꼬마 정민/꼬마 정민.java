import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        long a = Long.parseLong(arr[0]);
        long b = Long.parseLong(arr[1]);
        long c = Long.parseLong(arr[2]);

        System.out.println(a + b + c);

    }
}