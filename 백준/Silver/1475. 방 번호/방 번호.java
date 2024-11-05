import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];
        int roomNum = Integer.parseInt(br.readLine());

        // NOTE: 각 배열에 숫자 카운트
        while(roomNum != 0){
            int num = roomNum % 10;
            arr[num]++;
            roomNum /= 10;
        }
        // NOTE: 6과 9 바꿔 쓸 수 있음 -> 6과 9 중 하나로 통일(6이 2개이다 라고 생각)
        arr[6] += arr[9];
        arr[6] = arr[6] % 2 == 0 ? arr[6] / 2 : arr[6] / 2 + 1;
        arr[9] = 0;
        int needSet = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > needSet)
                needSet = arr[i];
        }
        System.out.println(needSet);
    }
}
