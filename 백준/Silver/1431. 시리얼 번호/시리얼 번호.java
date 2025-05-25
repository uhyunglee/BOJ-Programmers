// 시간복잡도 O(n log n)
// 접근방법: 숫자합을 미리 구해서 계산하여 시간복잡도 단축
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Serial> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Serial(br.readLine()));
        }

        Collections.sort(list);

        for (Serial s : list) {
            System.out.println(s.str);
        }
    }
    static class Serial implements Comparable<Serial> {
        String str;
        int digitSum;

        Serial(String str) {
            this.str = str;
            this.digitSum = calcDigitSum(str);
        }

        private int calcDigitSum(String s) {
            int sum = 0;
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) sum += c - '0';
            }
            return sum;
        }

        @Override
        public int compareTo(Serial o) {
            if (this.str.length() != o.str.length()) {
                return this.str.length() - o.str.length();
            }
            if (this.digitSum != o.digitSum) {
                return this.digitSum - o.digitSum;
            }
            return this.str.compareTo(o.str);
        }
    }
}