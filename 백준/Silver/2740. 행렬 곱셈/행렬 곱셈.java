import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] A = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        int[][] B = new int[m][k];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < k; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // multiply
        int[][] C = new int[n][k];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                for(int l = 0; l < m; l++){
                    C[i][j] += A[i][l] * B[l][j];
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

    }
}
