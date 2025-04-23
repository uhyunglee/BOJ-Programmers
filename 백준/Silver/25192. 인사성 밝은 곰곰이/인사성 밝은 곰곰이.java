import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        Set<String> set = new HashSet<>();
        while(n-- > 0){
            String line = br.readLine();
            if(line.equals("ENTER")){
                set.clear();
            }
            else if(!set.contains(line)){
                set.add(line);
                count++;
            }
        }
        System.out.println(count);
    }
}