import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String[] strArr = br.readLine().split(" ");
            String[] firstArr = strArr[0].split("");
            String[] secondArr = strArr[1].split("");

            Arrays.sort(firstArr);
            Arrays.sort(secondArr);

            boolean isPossible = false;
            for(int j = 0; j < firstArr.length; j++){
                if(firstArr[j].equals(secondArr[j])) {
                    isPossible = true;
                }else{
                    isPossible = false;
                    break;
                }
            }
            bw.write(isPossible ? "Possible\n": "Impossible\n");
        }
        bw.flush();
//        bw.close();
    }
}
