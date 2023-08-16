import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R, cnt, acc, day;
	static boolean isOpened;
	static 	   int[][] map;
	static 	   int[][]   v;
	static int[] di = {-1, 0, 1,  0};
	static int[] dj = { 0, 1, 0, -1};
	static void move(int number, int res) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(v[i][j] == number) map[i][j] = res;
			}
		}
	}
	static void open(int i, int j, int[][] map, int number) {
		cnt ++;
		acc += map[i][j];
		v[i][j] = number;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(0<= ni && ni < N && 0 <= nj && nj <N && v[ni][nj]==0) {
				if(Math.abs(map[i][j]-map[ni][nj])>=L && Math.abs(map[i][j]-map[ni][nj]) <= R) {
//					System.out.printf("(%d,%d)to(%d,%d)Opened || L : %d || R : %d || gap : %d\n",i,j,ni,nj,L,R,Math.abs((map[i][j]-map[ni][nj])));
					isOpened= true;
					open(ni,nj,map,number);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];

		
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		isOpened = true;
		while(isOpened) {
			int number = 1;
			isOpened = false;
			v   = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(v[i][j]==0) {
						open(i,j,map, number);
						move(number,acc/cnt);						
						number ++;
						cnt = 0;
						acc = 0;
//						for (int[] m : map) {
//							System.out.println(Arrays.toString(m));
//						}System.out.println("-----------------");
					}
				}
			}
			if(!isOpened)break;
			day ++;
		}
		System.out.println(day);
		br.close();

	}
}