import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
//            tmp.trim();
            ArrayDeque<Character> L = new ArrayDeque<>();
            ArrayDeque<Character> R = new ArrayDeque<>();

            for(char c : tmp.toCharArray()){
                if(c == '<'){
                    if(L.isEmpty()) continue;
                    R.addFirst(L.pollLast());
                }else if(c == '>'){
                    if(R.isEmpty()) continue;
                    L.addLast(R.pollFirst());
                }else{
                    if(c == '-'){
                        if(L.isEmpty()) continue;
                        L.pollLast();
                        continue;
                    }
                    L.addLast(c);
                }
            }
            String res1 = L.stream().map(String::valueOf).collect(Collectors.joining(""));
            String res2 = R.stream().map(String::valueOf).collect(Collectors.joining(""));
            StringBuilder sb = new StringBuilder();
            sb.append(res1);
            sb.append(res2);
            System.out.println(sb);
        }
    }
}