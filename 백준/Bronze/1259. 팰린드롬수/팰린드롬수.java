import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String line = br.readLine();
            if(line.equals("0")) break;

            int left = 0;
            int right = line.length() - 1;
            boolean isPalindrome = true;
            while(left < right){
                if(line.charAt(left) != line.charAt(right)){
                    isPalindrome = false;
                    break;
                }
                left++;
                right--;
            }
            bw.write(isPalindrome ? "yes\n" : "no\n");
        }
        bw.flush();
        bw.close();
    }
}
