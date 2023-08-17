import java.util.*;
import java.io.*;
public class Main{
	static boolean[][] v;
	static int[] di = {-1,-1, 0, 1, 1, 1, 0,-1};
	static int[] dj = { 0, 1, 1, 1, 0,-1,-1,-1};
	static void getIsland(int[][] map, int h, int w,int i, int j) {
		v[i][j] = true;
		for (int d = 0; d < 8; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(0<=ni&&ni<h&& 0<=nj&&nj<w && !v[ni][nj] && map[ni][nj]==1) {
				getIsland(map,h,w,ni,nj);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int ans = 0;
			
			//종료조건
			if(w==0 && h==0) break;
			
			int[][] map = new int[h][w];
			v = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !v[i][j]) {
						getIsland(map,h,w,i,j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
