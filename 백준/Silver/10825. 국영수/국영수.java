// 시간복잡도 : O(nlogn)

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, korean, english, math));
        }
        // NOTE:
        // 1. 국어 점수 감소
        // 2. 국어 점수 같으면 영어 점수 증가
        // 3. 국,영 같으면 수학 점수 감소
        // 4. 모두 같으면 사전순
        list.sort((o1, o2) -> {
            if(o1.korean != o2.korean)
                return o2.korean - o1.korean;
            else if(o1.english != o2.english)
                return o1.english - o2.english;
            else if(o1.math != o2.math)
                return o2.math - o1.math;
            else return o1.name.compareTo(o2.name);
        });

        for(int i = 0; i < list.size(); i++){
            bw.write(list.get(i).name + "\n");
        }

        bw.flush();
        bw.close();

    }
}
class Student{
    String name;
    int korean, english, math;

    public Student(String name, int korean, int english, int math){
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}