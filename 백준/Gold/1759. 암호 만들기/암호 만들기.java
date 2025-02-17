import java.io.*;
import java.util.*;

public class Main {
    static int l, c;
    static char[] input;
    static char[] password;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        input = new char[c];
        password = new char[l];
        input = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(input);

        generate(0, 0, 0);


        bw.flush();
        bw.close();
    }

    static void generate(int length, int index, int vowelCount) throws IOException {
        // base case
        if(length == l){
            // TODO: 검사
            if(vowelCount >= 1 && l - vowelCount >= 2){ // 모음 개수 && 자음개수
                bw.write(password);
                bw.write('\n');
            }
            return;
        }

        // recursive case
        if(index < c){ // 입력에서 뽑을 숫자가 남아있는 경우
            // password에 input[index] 사용하는 경우
            password[length] = input[index];
            int v = isVowel(input[index]) ? 1 : 0;
            generate(length + 1, index + 1, vowelCount + v);

            // password에 input[index] 사용하지 않는 경우
            password[length] = 0;
            generate(length, index + 1, vowelCount);
        }
    }
    static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}