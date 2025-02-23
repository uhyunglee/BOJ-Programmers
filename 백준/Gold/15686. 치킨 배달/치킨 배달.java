import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Node> chickenList = new ArrayList<>();
    static ArrayList<Node> houseList = new ArrayList<>();
    static boolean[] chickenVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) houseList.add(new Node(i, j));
                else if(board[i][j] == 2) chickenList.add(new Node(i, j));
            }
        }
        chickenVisited = new boolean[chickenList.size()];
        backtracking(0, 0);
        System.out.println(min);
    }

    static void backtracking(int count, int idx){
        // base
        if(count == m) {
            int tot = 0;
            for(int i = 0; i < houseList.size(); i++){
                int sum = Integer.MAX_VALUE;
                for(int j = 0; j < chickenList.size(); j++){
                    if(chickenVisited[j]){
                        int dist = Math.abs(houseList.get(i).r - chickenList.get(j).r)
                                + Math.abs(houseList.get(i).c - chickenList.get(j).c);
                        sum = Math.min(sum, dist);
                    }
                }
                tot += sum;
            }
            min = Math.min(tot, min);
            return;
        }

        for(int i = idx; i < chickenList.size(); i++){
            if(!chickenVisited[i]){
                chickenVisited[i] = true;
                backtracking(count + 1, i + 1);
                chickenVisited[i] = false;
            }
        }
    }
    public static class Node{
        int r, c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}