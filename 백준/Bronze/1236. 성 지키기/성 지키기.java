import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] arr = new char[N][M];

        for(int i=0; i<N; i++){
            String line = sc.next();
            for(int j = 0; j < M; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        // 1) 각 행, 열에 대해 경비원이 있는지
        boolean[] rowExist = new boolean[N];
        boolean[] colExist = new boolean[M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 'X'){
                    rowExist[i] = true;
                    colExist[j] = true;
                }
            }
        }
        // 2) 보호받지 못하는 행, 열의 개수
        int rowCount = N;
        int colCount = M;
        for(int i = 0; i < N; i++){
            if(rowExist[i] == true) rowCount--;
        }
        for(int j = 0; j < M; j++){
            if(colExist[j] == true) colCount--;
        }

        // 3) 둘 중 큰 값
        System.out.println(Math.max(rowCount, colCount));

    }
}
