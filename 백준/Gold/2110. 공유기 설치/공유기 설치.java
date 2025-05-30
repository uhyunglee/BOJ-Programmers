import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
import java.util.Arrays;
 
public class Main {
	
	public static int[] house;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		house = new int[N];
		
		for(int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);	// 이분탐색을 하기 위해선 반드시 정렬 되어있어야 한다.
		
		
		int lo = 1;		// 최소 거리가 가질 수 있는 최솟값
		int hi = house[N - 1] - house[0] + 1;	// 최소 거리가 가질 수 있는 최댓값
		
		while(lo < hi) {	// Upper Bound 형식
			
			int mid = (hi + lo) / 2;
			
			
			if(canInstall(mid) < M) {
				hi = mid;
			}
			else {
				
				lo = mid + 1;
			}
		}
		
		
		System.out.println(lo - 1);
	}
	
	// distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
	public static int canInstall(int distance) {
		
		// 첫 번째 집은 무조건 설치한다고 가정
		int count = 1;
		int lastLocate = house[0];
		
		for(int i = 1; i < house.length; i++) {
			int locate = house[i];
			
			
			if(locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		return count;
		
	}
	
	
}