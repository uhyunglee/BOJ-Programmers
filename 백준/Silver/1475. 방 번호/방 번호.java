import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roomNum = Integer.parseInt(br.readLine());

        // N <= 1,000,000 -> N log N
        int[] set = new int[10];

        // NOTE: 각 배열에 숫자 카운트
        while(roomNum != 0){
           int num = roomNum % 10;
           set[num]++;
           roomNum /= 10;
        }
        // NOTE: 6과 9를 바꿔쓸 수 있음 -> 하나로 생각.
        set[6] += set[9];
        set[6] = set[6] % 2 == 0 ? set[6] / 2 : set[6] / 2 + 1;
        set[9] = 0;

        int needSet = -1;
        for(int i = 0; i < set.length; i++){
            if(set[i] > needSet){
                needSet = set[i];
            }
        }
        System.out.println(needSet);
    }
}