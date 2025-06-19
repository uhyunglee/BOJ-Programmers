// 시간복잡도: O(k * n^2)
// 접근방법: 브루트포스
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] eating = new int[d+1];	
        eating[c] = 3001;
        int[] sushi = new int[N];
        int count = 1;	//무료 초밥이 1개 있으므로 default Value = 
        //회전 벨트 정보 저
        for(int i=0;i<N;i++)
            sushi[i] = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            int sushiId = sushi[i];
            if(eating[sushiId]==0)
                count++;
            eating[sushiId]++;
        }
        int max = count;
        for(int i=0;i<N-1;i++){
            int s_id = sushi[i];
            int e_id = sushi[i+k<N ? i+k : (i+k) % N];
            if(--eating[s_id] == 0)	
                count--;
            if(++eating[e_id] == 1)	
                count++;
            max = Math.max(max, count);
        }
        bw.write(String.valueOf(max));	
        bw.flush();		
        bw.close();
        br.close();
    }
}