import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 2) {
            System.out.println(0);
            return;
        }

        List<Integer> primes = getPrimes(N);

        int count = 0;
        int start = 0, end = 0;
        int sum = primes.get(0);

        while (true) {
            if (sum == N) count++;

            if (sum >= N) {
                sum -= primes.get(start++);
            } else {
                if (++end >= primes.size()) break;
                sum += primes.get(end);
            }
        }
        System.out.println(count);
    }

    private static List<Integer> getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) isPrime[i] = true;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }
}