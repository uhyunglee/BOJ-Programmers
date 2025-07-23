import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;
            flowers[i] = new Flower(start, end);
        }

        Arrays.sort(flowers, (f1, f2) -> {
            if (f1.start == f2.start) return f2.end - f1.end;
            return f1.start - f2.start;
        });

        int startDay = 301, endDay = 1201;
        int idx = 0, max = 0, answer = 0;
        while (startDay < endDay) {
            boolean isFind = false;
            for (int i = idx; i < N; i++) {
                if (flowers[i].start > startDay) break;

                if (flowers[i].end > max) {
                    max = flowers[i].end;
                    isFind = true;
                    idx = i + 1;
                }
            }

            if (isFind) {
                answer++;
                startDay = max;
            } else break;
        }
        if (max < endDay) System.out.println(0);
        else System.out.println(answer);
    }

    static class Flower {
        int start, end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}