import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = "";
        while(!(line = br.readLine()).isEmpty()){
            if(line.equals("0")) break;
            int[] arr = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
            boolean isPanlindrome = true;
            int left = 0;
            int right = arr.length - 1;
            while(left < right){
                if(arr[left] == arr[right]){
                    left++;
                    right--;
                    isPanlindrome = true;
                }else{
                    isPanlindrome = false;
                    break;
                }
            }
            if(isPanlindrome)
                bw.write("yes\n");
            else bw.write("no\n");
        }
        bw.flush();
        bw.close();
    }
}
