
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();
        while(P-- > 0){
            // 입력
            int testCase = sc.nextInt();
            int[] students = new int[20];
            for(int i = 0; i < 20; i++){
                students[i] = sc.nextInt();
            }
            // 정렬
            int count = 0;
            for(int i = 0; i < 20; i++){
                for(int j = 0; j < i; j++){
                    if(students[j] > students[i]) {
                        int front = students[i];
                        for (int k = i - 1; k >= j; k--) {
                            students[k + 1] = students[k];
                            count++;
                        }
                        students[j] = front;
                        break;
                    }
                }
            }
            // 출력
//            for(int i=0; i<20; i++){
//                System.out.print(students[i] + " ");
//            }

            System.out.println(testCase + " " + count);

        }
    }
}
