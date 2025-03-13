import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            Map<String, String> map = new HashMap<>();
            String[] crying = br.readLine().split(" ");
            String line;
            while((line = br.readLine()) != null){
                if(line.equals("what does the fox say?")) break;
                String[] animal = line.split(" ");
                for(int i = 0; i < crying.length; i++){
                    if(crying[i] != null && crying[i].equals(animal[2])){
                        crying[i] = null;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < crying.length; i++){
                if(crying[i] != null){
                    sb.append(crying[i] + " ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}