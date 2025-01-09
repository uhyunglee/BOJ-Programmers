import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dices = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.sort(dices);

        // Case 1: 같은 눈 3개 -> 10000 + dice x 1000
        if(dices[0] == dices[1] && dices[1] == dices[2]){
            System.out.println(10000 + dices[1] * 1000);
        }
        // Case 2: 같은 눈 2개 -> 1000 + dice * 100
        else if(dices[0] == dices[1] || dices[1] == dices[2]) {
            System.out.println(1000 + dices[1] * 100);
        }
        // Case 3: 다른 눈 3개 -> 가장 큰 눈 x 100
        else if(dices[0] != dices[1] && dices[1] != dices[2]) {
            System.out.println(dices[2] * 100);
        }
    }
}