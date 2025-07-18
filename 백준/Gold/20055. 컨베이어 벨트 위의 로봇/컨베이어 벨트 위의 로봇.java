import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] belt;
    static boolean[] robot;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[2*n+1]; //컨베이어 벨트 내구도 저장
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=2*n; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        //내구도가 0인 칸의 개수가 k 이상이라면 종료
        cnt = 0;
        int level = 0;
        robot = new boolean[2*n+1]; //로봇 위치
        while(cnt < k){
            level++;

            //컨테이너벨트 한 칸 회전
            rotateBelt();

            //가장 먼저 올라간 로봇부터 이동할 수 있다면 한 칸 이동 -> 내구도 1 감소
            moveRobot();

            //1번 위치에서 로봇이 올라갈 수 있다면 올라감 -> 내구도 1 감소
            if(belt[1]>=1 && !robot[1]){
                robot[1] = true;
                belt[1]--;
                if(belt[1]==0) cnt++;
            }
        }

        System.out.println(level);
    }

    public static void moveRobot(){
        //내구도가 1이상, 다른 로봇이 없음
        for(int i=n-1; i>=1; i--){
            if(!robot[i]) continue;
            if(belt[i+1]>=1 && !robot[i+1]){
                robot[i+1] = true;
                robot[i] = false; //로봇 이동
                belt[i+1]--; //내구도 감소
                if(belt[i+1]==0) cnt++;
            }
        }

        //n에 위치한 로봇 내리기
        if(robot[n]) robot[n] = false;
    }

    public static void rotateBelt(){
        int temp = belt[2*n];
        for(int i=2*n-1; i>=1; i--){
            belt[i+1] = belt[i];
        }
        belt[1] = temp;

        //로봇 위치 배열도 회전
        boolean tempR = robot[n];
        for(int i=n-1; i>=1; i--){
            robot[i+1] = robot[i];
        }
        robot[1] = tempR;

        //n에 위치한 로봇 내리기
        if(robot[n]) robot[n] = false;

    }
}