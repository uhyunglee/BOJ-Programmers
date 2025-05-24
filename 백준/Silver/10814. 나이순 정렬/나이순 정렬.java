// 접근방법: 계수정렬 응용 
// 시간복잡도 O(N) N<= 100,000

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder[] ageGroups = new StringBuilder[201];

        for(int i = 0; i < ageGroups.length; i++){
            ageGroups[i] = new StringBuilder();
        }
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            ageGroups[age].append(age).append(' ').append(name).append('\n');
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder person : ageGroups){
            result.append(person);
        }
        System.out.println(result);
    }
}