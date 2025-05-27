// 시간복잡도: O(nlogn)
// 접근방법: 빈도수가 같을 경우 처음등장하는 인덱스를 따로 저장하는 Map을 선언 

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if(!firstIndex.containsKey(num)){
                firstIndex.put(num, i);
            }
        }

        list.sort((o1, o2) -> {
            int num1 = freq.get(o1);
            int num2 = freq.get(o2);
            if(num1 != num2) return Integer.compare(num2, num1);
            return Integer.compare(firstIndex.get(o1), firstIndex.get(o2));
        });


        StringBuilder sb = new StringBuilder();
        for(int num : list){
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}