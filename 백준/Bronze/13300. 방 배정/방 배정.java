import java.io.*;
import java.util.*;
/*
남자끼리 여자끼리 , 한 방에 같은 학년 배정, 한명만 배정도 가능.
최대인원수 K <= 1000
학생 수 N <= 1000
S 성별 0 여학생 1 남학생
Y 학년 1<= Y<= 6
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] students = new int[6][2];
        int count = 0;
        // NOTE: 주어진 학생 분류
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            students[grade - 1][s]++;
        }
        // NOTE: 학생 배열 순회
        for(int i = 0; i < students.length; i++){
            for(int j = 0; j < students[i].length; j++){
                count += students[i][j] / k;
                if(students[i][j] % k != 0)
                    count += 1;
            }
        }
        System.out.println(count);


    }
}
