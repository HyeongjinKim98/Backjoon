import java.util.*;
import java.io.*;
public class Main{
	static int sum = 0;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = { 0, 1, 0,-1};
	static     int[][]   paper = new     int[100][100];
	static boolean[][] visited = new boolean[100][100];
	
	static void Dfs(int i, int j) {
		sum++;
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni < 0 || ni >= 100 || nj < 0 || nj >= 100) continue;
			
			if(paper[ni][nj] > 0 && !visited[ni][nj] ) {
				Dfs(ni,nj);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <tc; i++) {
			st= new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			for (int a = 0;  a<10; a++) {
				for (int b = 0;  b< 10; b++) {
					paper[x+a][y+b] += 1;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(paper[i][j]>0 && !visited[i][j]) {
					Dfs(i,j);
				}
			}
		}
		System.out.println(sum);
	}
}
