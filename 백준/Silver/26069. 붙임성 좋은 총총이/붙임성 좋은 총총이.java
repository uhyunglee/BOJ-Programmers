import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        while(n -- > 0){
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            if(set.contains(str1)){
                set.add(str2);
            }
            if(set.contains(str2)){
                set.add(str1);
            }
        }
        System.out.println(set.size());
    }
}