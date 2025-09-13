import java.util.*;
import java.io.*;

public class Main {
    static int K, V, E, u, v;
    static int color[];
    static ArrayList<ArrayList<Integer>> connect;
    static String answer;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            answer = "YES";
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            connect = new ArrayList<>();

            for(int j = 0; j <= V; j++){
                connect.add(new ArrayList<>()); 
            }

            for(int j = 0; j < E; j++){
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());

                connect.get(u).add(v);
                connect.get(v).add(u);
            }

            color = new int[V+1];
            for(int j = 1; j <= V; j++){
                if(color[j] == 0){
                    if(!bfs(j))
                        break;
                }
            }
            System.out.println(answer);
        }
    }

    public static boolean bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            for(Integer i: connect.get(now)){
                if(color[now] == color[i]){
                    answer = "NO";
                    return false;
                }
                if(color[i] == 0){
                    color[i] = color[now] *- 1;
                    q.add(i);
                }
            }
        }
        return true;
    }
}
