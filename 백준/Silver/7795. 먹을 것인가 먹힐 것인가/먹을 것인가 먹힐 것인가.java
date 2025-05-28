// 시간복잡도 : O(logn)
// 접근방법 : n < 20,000 정렬된 배열에서 이분탐색으로 접근

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());


        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(B);
            int temp = 0;
            for(int i=0;i<N;i++) {
                int low = 0;
                int high = M-1;
                int cnt = 0;
                while(low<=high) {
                    int mid = (low+high)/2; //중간값
                    if(B[mid]<A[i]) {
                        low = mid+1;
                        cnt = mid+1;
                    }
                    else
                        high = mid-1;
                }
                temp+=cnt;
            }
            result.append(temp+"\n");
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        
    }
}