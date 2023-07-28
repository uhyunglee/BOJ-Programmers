import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        char[] arr1 = new char[26];
        char[] arr2 = new char[26];
        int count = 0;

        for(int i = 0; i < str1.length(); i++){
            arr1[str1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < str2.length(); i++){
            arr2[str2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] > arr2[i])
                count += arr1[i] - arr2[i];
            else if(arr1[i] < arr2[i])
                count += arr2[i] - arr1[i];
        }
        System.out.println(count);
    }
}
