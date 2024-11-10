import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int count = 0;

        // NOTE: 알파벳 인덱스 배열 생성
        for(int i = 0; i < word1.length; i++){
            arr1[word1[i] - 97]++;
        }
        for(int i = 0; i < word2.length; i++){
            arr2[word2[i] - 97]++;
        }

        // NOTE: 알파벳 배열 순회
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                int max = Math.max(arr1[i], arr2[i]);
                int min = Math.min(arr1[i], arr2[i]);
                count += (max - min);
            }
        }

        System.out.println(count);

    }
}
