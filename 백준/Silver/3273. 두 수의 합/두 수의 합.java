import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // NOTE: 1<= a <= 1,000,000
        // two pointer
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        list.sort(null); // 오름차순 정렬
        int x = Integer.parseInt(br.readLine());
        int count = 0;

        int left = 0;
        int right = n - 1;
        while(left != right){
            int sum = list.get(left) + list.get(right);
            if(sum == x){
                count++;
                left++;
            }else if(sum > x) right--;
            else left++;
        }
        System.out.println(count);
    }
}
