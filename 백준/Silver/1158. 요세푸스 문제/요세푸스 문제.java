import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        List<Integer> list = IntStream.range(0, n).boxed().map(i -> i + 1).collect(Collectors.toList());

        int index = 0;
        sb.append("<");
        while(list.size() > 1){
            index = (index + k - 1) % list.size();
            sb.append(list.remove(index) + ", ");
        }
        sb.append(list.remove(0) + ">");
        System.out.println(sb.toString());

    }
}