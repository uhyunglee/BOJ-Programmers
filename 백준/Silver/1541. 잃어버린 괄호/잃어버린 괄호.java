import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        String[] minusSplit = expression.split("-");

        int result = sum(minusSplit[0]);

        for (int i = 1; i < minusSplit.length; i++) {
            result -= sum(minusSplit[i]); 
        }

        System.out.println(result);
    }

    public static int sum(String str) {
        String[] tokens = str.split("\\+");
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}