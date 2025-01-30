import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();  // 도화지의 세로 크기 n
		int m = sc.nextInt();  // 도화지의 가로 크기 m
		
		int[][] pictureArr = new int[n + 2][m + 2];  // 그림 배열
		int[][] visited = new int[n + 2][m + 2];  // 처리 여부 저장 배열
		
		int[] dx = {1, 0, -1, 0};  // 우 상 좌 하
		int[] dy = {0, 1, 0, -1};
		
		for (int i = 1; i <= n; i++) {  // 그림 배열값 세팅
			for (int j = 1; j <= m; j++) {
				pictureArr[i][j] = sc.nextInt();
			}
		}
		
		
		Queue<Pair> queue = new ArrayDeque<>();  // 큐 생성
		int count = 0;  // 그림의 개수
		int maxSize = 0;  // 그림의 최대 크기
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				
				if (pictureArr[i][j] == 1 && visited[i][j] == 0) {  // 시작 좌표가 그림이고, 아직 방문하지 않았으면
					int size = 0;  // 그림의 크기
					
					queue.add(new Pair(i, j));  // 큐에 삽입
					visited[i][j] = 1;  // 방문 완료 갱신
					
					while (!queue.isEmpty()) {  // 큐가 비어있지 않으면 (큐가 빌 때까지 반복)
						Pair pair = queue.remove();  // 큐에서 front 좌표를 꺼내고
						size++;  // 해당 그림의 크기 갱신
						
						for (int d = 0; d < 4; d++) {  // 해당 좌표의 주변 좌표를 우상좌하 순으로 탐색 
							int tmpX = pair.X + dx[d];  // 주변 좌표 : (tmpX, tmpY)
							int tmpY = pair.Y + dy[d];
							
							if (pictureArr[tmpX][tmpY] == 1 && visited[tmpX][tmpY] == 0) {  // 그림이고, 아직 방문하지 않았으면
								queue.add(new Pair(tmpX, tmpY));  // 큐에 해당 좌표 삽입
								visited[tmpX][tmpY] = 1;  // 방문 완료 갱신
							}
						}
					}
					count++;  // 그림의 개수 갱신
					if (size > maxSize) maxSize = size;  // 그림의 최대 크기 갱신
				}
			}
		}
		
		System.out.println(count + "\n" + maxSize);

	}

}

class Pair {  // 좌표 값을 저장할 자료구조 Pair 
	int X;
	int Y;
	
	Pair(int x, int y) {
		this.X = x;
		this.Y = y;
	}
}