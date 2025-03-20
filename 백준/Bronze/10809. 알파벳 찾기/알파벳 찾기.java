import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for(int i = 0; i < sb.length(); i++){
            if(arr[sb.charAt(i) - 97] == -1) // 처음등장
                arr[sb.charAt(i) - 97] = i;
        }
        for(int i : arr){
            System.out.print(i + " ");
        }

    }
}