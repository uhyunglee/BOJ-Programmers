import java.util.*;
import java.io.*;

public class Main {
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int ans;
    public static class Fish {
        int x;
        int y;
        int dir;
        public Fish(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int[][] map = new int[4][4];
        HashMap<Integer, Fish> hash = new HashMap<>();

        for(int i=0;i<4;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<4;j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                hash.put(num, new Fish(i, j, dir-1));
            }
        }

        int s_x = 0;
        int s_y = 0;
        Fish first = hash.get(map[0][0]);
        ans = map[0][0];
        int s_dir = first.dir;
        int num = map[0][0];
        map[0][0] = 0;
        hash.remove(num);


        dfs(map, hash, num, new Fish(s_x, s_y, s_dir));
        System.out.println(ans);


    }

    public static void dfs(int[][] map, HashMap<Integer, Fish> hash, int sum, Fish shark) {
        ans = Math.max(ans, sum);

        int[][] map_copy = new int[4][4];
        for(int i=0;i<4;i++) {
            map_copy[i] = map[i].clone();
        }
        HashMap<Integer, Fish> hash_copy = (HashMap<Integer, Fish>) hash.clone();

        for(int k=1;k<=16;k++) {
            if(!hash.containsKey(k)) continue;
            Fish fish = hash_copy.get(k);
            if(map[fish.x][fish.y] == 0) continue;

            int dir = fish.dir;
            int turn_cnt = 0;
            boolean check = false;
            int nx = fish.x;
            int ny = fish.y;
            while(turn_cnt++ < 8) {
                nx = fish.x + dx[dir];
                ny = fish.y + dy[dir];
                if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (nx == shark.x && ny == shark.y)) {
                    dir = (dir+1) % 8;
                } else {
                    check = true;
                    break;
                }
            }
            if(check) {
                if(map_copy[nx][ny] != 0) {
                    map_copy[fish.x][fish.y] = map_copy[nx][ny];
                    Fish move_fish = hash_copy.get(map_copy[nx][ny]);
                    hash_copy.put(map_copy[nx][ny], new Fish(fish.x, fish.y, move_fish.dir));
                    map_copy[nx][ny] = k;
                    hash_copy.put(k, new Fish(nx, ny, dir));

                } else {
                    map_copy[nx][ny] = k;
                    hash_copy.put(k, new Fish(nx, ny, dir));
                    map_copy[fish.x][fish.y] = 0;
                }
            }

        }

        for(int m=1;m<=4;m++) {
            int nx = shark.x + dx[shark.dir] * m;
            int ny = shark.y + dy[shark.dir] * m;

            if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
            if(map_copy[nx][ny] != 0) {
                int num = map_copy[nx][ny];
                map_copy[nx][ny] = 0;
                int dir = hash_copy.get(num).dir;
                hash_copy.remove(num);
                dfs(map_copy, hash_copy, sum+num, new Fish(nx, ny, dir));
                hash_copy.put(num, new Fish(nx, ny, dir));
                map_copy[nx][ny] = num;
            }

        }

    }
}