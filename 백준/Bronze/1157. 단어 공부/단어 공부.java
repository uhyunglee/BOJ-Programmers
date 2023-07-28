
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        str = str.toLowerCase();
        int[] arr = new int[26];
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - 'a']++;
        }
        int max = -1;
        int idx = 0;
        char maxAlphabet = '?';

        for(int i = 0 ; i < arr.length; i++){
            if(max < arr[i]) {
                max = arr[i];
                maxAlphabet = (char)(i + 65);
            }else if(max == arr[i]){
                maxAlphabet = '?';
            }
        }
        System.out.println(maxAlphabet);
    }
}
