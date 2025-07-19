import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] dice;
	public static int ans;
	
	public static int[] connect;
	public static int[] score;
	public static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dice = new int[10];
		String[] data = br.readLine().split(" ");
		for(int i=0;i<10;i++) {
			dice[i] = Integer.parseInt(data[i]);
		}
		
		connect = new int[33];
		score = new int[33];
		
		for(int i=0;i<21;i++) {
			connect[i] = i+1;
			score[i] = i*2;
		}
		// 도착
		connect[21] = 21;
		score[21] = 0;
		
		// 10 안  (22 ~ 24)
		connect[22] = 23;
		connect[23] = 24;
		connect[24] = 30;
		score[22] = 13;
		score[23] = 16;
		score[24] = 19;
		
		// 20 안 (25 ~ 26)
		connect[25] = 26;
		connect[26] = 30;
		score[25] = 22;
		score[26] = 24;
		
		// 30 안 (27 ~ 32)
		connect[27] = 28;
		connect[28] = 29;
		connect[29] = 30;
		connect[30] = 31;
		connect[31] = 32;
		connect[32] = 20;
		
		score[27] = 28;
		score[28] = 27;
		score[29] = 26;
		score[30] = 25;
		score[31] = 30;
		score[32] = 35;
		
		ans = 0;
		check = new boolean[33];
		dfs(new int[5], 0, 0);
		System.out.println(ans);
	}
	
	public static void dfs(int[] horse, int depth, int sum) {
		if(depth == 10) {

			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=0;i<5;i++) {
			int x = horse[i];
			int now = horse[i];
			int move = dice[depth];

			if(x == 5) {
				x = 22;
				move--;
			} else if(x==10) {
				x = 25;
				move--;
			} else if(x==15) {
				x = 27;
				move--;
			}

			if(x+move <= 21) {
				x += move;
			} else {
				for(int m=0;m<move;m++) {
					x = connect[x];
				}
			}
	
			
			if(check[x] &&  x != 21) {
				continue;
			}

			check[x] = true;
			check[now] = false;
			horse[i] = x;
		
			dfs(horse, depth+1, sum+score[x]);
			
			check[x] = false;
			check[now] = true;
			horse[i] = now;
			

		}
	}
	

}