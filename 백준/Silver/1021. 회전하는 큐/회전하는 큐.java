import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int[] findNums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        // NOTE: 인덱스 값을 알아야하므로 LinkedList선택
        LinkedList<Integer> deque = new LinkedList<>(IntStream.rangeClosed(1, n)
                .boxed().collect(Collectors.toList()));
        int answer = 0;

        // NOTE: 중간 인덱스보다 앞 -> 2번연산 || 중간인덱스보다 뒤 -> 3번연산
        for(int i = 0; i < m; i++){
            int targetIdx = deque.indexOf(findNums[i]);
            int midIdx = deque.size() % 2 == 0 ? deque.size() / 2 - 1 : deque.size() / 2;

            if(targetIdx <= midIdx){
                // NOTE: 2번연산
                for(int j = 0; j < targetIdx; j++){
                    deque.addLast(deque.pollFirst());
                    answer++;
                }
            }else{
                for(int j = 0; j < deque.size() - targetIdx; j++){
                    deque.addFirst(deque.pollLast());
                    answer++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(answer);
    }
}