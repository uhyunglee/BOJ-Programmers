import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        while(n-- > 0){
            String name = br.readLine();
            map.put(name, 1);
        }
        while(m-- > 0){
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 2){
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        bw.write(list.size() + "\n");
        for(String name : list){
            bw.write(name + "\n");
        }
        bw.flush();
        bw.close();
    }
}