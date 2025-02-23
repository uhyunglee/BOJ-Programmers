import java.io.*;
import java.util.*;

public class Main {
    //스티커 정보 관련 클래스
    static class Sticker{
        int R, C;
        int[][] shape;
        public Sticker(int R, int C, int[][] shape){
            this.R = R;
            this.C = C;
            this.shape = shape;
        }
    }
    static boolean[][] visited;	//모눈종이 관련 배열
    static int result = 0;
    static int N, M, K;
    //스티커 저장 리스트
    static ArrayList<Sticker> stickers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        //모든 스티커 정보 저장
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[R][C];
            for(int j=0;j<R;j++){
                st = new StringTokenizer(br.readLine()," ");
                for(int s=0;s<C;s++)
                    sticker[j][s] = Integer.parseInt(st.nextToken());
            }
            stickers.add(new Sticker(R, C, sticker));
        }
        //스티커 붙이는 과정 진행
        search(0, 0);
        bw.write(result + "\n");	//붙인 스티커의 칸수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //스티커 붙이는 과정 진행하는 함수
    static void search(int cnt, int val){
        //모든 스티커 붙이는 과정이 끝났을 때
        if(cnt == K){
            result = Math.max(val, result);
            return;
        }
        Sticker cur = stickers.get(cnt);
        //회전하지 않고 스티커를 붙일 때
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) {
                if(cur.R > (N-i) || cur.C > (M-j))	//모눈종이 범위를 벗어날 때
                    continue;
                int temp = attach(i, j, cur);	//현재 스티커 붙이기
                if(temp == -1)	//해당 위치 현재 스티커 붙이기 불가능할 때
                    continue;
                search(cnt+1,val + temp);	//다음 스티커 붙이기
                return;
            }
        }
        //회전을 통해 스티커 붙이기 진행
        for(int i=0;i<3;i++){
            rotate(cur);	//스티커 회전
            for(int j=0;j<N;j++){
                for(int s=0;s<M;s++){
                    if(cur.R > (N-j) || cur.C > (M-s))	//모눈종이 범위를 벗어날 때
                        continue;
                    int temp = attach(j, s, cur); //회전한 스티커 붙이기
                    if(temp == -1) //해당 위치 회전한 스티커 붙이기 불가능할 때
                        continue;
                    search(cnt+1,val + temp); //다음 스티커 붙이기
                    return;
                }
            }
        }
        search(cnt+1,val);	//현재 스티커 버리고 다음 스티커 붙이기
    }
    //스티커 회전하는 함수(배열 돌리기)
    static void rotate(Sticker sticker){
        //배열을 돌린 결과가 저장될 배열
        int[][] tempSticker = new int[sticker.C][sticker.R];

        //배열 돌리기(90도)
        for(int i=0;i<sticker.R;i++){
            for(int j=0;j<sticker.C;j++)
                tempSticker[j][sticker.R-1-i] = sticker.shape[i][j];
        }
        //행과 열의 값 반전시키기
        int temp = sticker.R;
        sticker.R = sticker.C;
        sticker.C = temp;
        sticker.shape = tempSticker;
    }
    //스티키 붙이기 진행하는 함수
    static int attach(int r, int c, Sticker sticker){
        int result = 0;
        for(int i=0;i<sticker.R;i++){
            for(int j=0;j<sticker.C;j++){
                if(sticker.shape[i][j] == 1){
                    if(visited[r+i][c+j])	//모눈종이에 이미 스티커가 붙인 경우
                        return -1;	//스티커 붙이기 실패
                    result++;
                }
            }
        }
        //스티커 붙인 칸 방문 확인하기
        for(int i=0;i<sticker.R;i++){
            for(int j=0;j<sticker.C;j++){
                if(sticker.shape[i][j] == 1)
                    visited[r+i][c+j] = true;
            }
        }
        return result;	//스티커 붙인 칸 수 반환
    }
}