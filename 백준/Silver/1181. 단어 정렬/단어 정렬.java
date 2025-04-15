import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        while(n-- > 0){
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()));

        for (String s : list) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}