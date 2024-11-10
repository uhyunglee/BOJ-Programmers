import java.io.*;
import java.util.*;

public class Main {
    static int moveLeft(int cursor){
        if(cursor == 0) return cursor; // 맨 앞
        cursor -= 1;

        return cursor;
    }
    static int moveRight(int cursor){
        if(cursor == sb.length()) return cursor; // 맨 뒤
        cursor += 1;

        return cursor;
    }
    static StringBuilder delete(){
        if(cursor == 0) return sb;
        if(cursor < 0) cursor = 0;
        if(cursor > sb.length()) cursor = sb.length();
        sb.deleteCharAt(cursor - 1);
        cursor -= 1;

        return sb;
    }
    static StringBuilder append(String letter){
        sb.insert(cursor, letter);
        cursor += 1;

        return sb;
    }

    static StringBuilder sb;
    static int cursor;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder(br.readLine());
        cursor = sb.length();
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] command = br.readLine().split(" ");
            if(command[0].equals("L")){ // 커서 왼쪽 한칸(맨 앞 무시)
                cursor = moveLeft(cursor);
            }else if(command[0].equals("D")){ // 커서 오른쪽 한칸(맨 뒤 무시)
                cursor = moveRight(cursor);
            }else if(command[0].equals("B")){ // 커서 왼쪽 문자 삭제(맨 앞 무시)
                sb = delete();

            }else if(command[0].equals("P")){ // 커서 왼쪽 문자 추가
                sb = append(command[1]);
            }
        }
        System.out.println(sb.toString());
    }
}