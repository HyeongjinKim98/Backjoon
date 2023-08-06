import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] up   = new int[N];
		int[] down = new int[N];
		
		// up[  1    2  ..... N-1   N ]
		// do[ 2N 2N-1  ..... N+2 N+1 ]
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) up[i]   = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) down[N-i-1] = Integer.parseInt(st.nextToken());
		
		System.out.println(factory(N,K,up,down));
	}
	
	public static boolean check(int[] up, int[] down, int K) {
		int count = 0;
		for (int i = 0; i < up.length; i++) {
			if(up[i] == 0) count++;
			if(down[i] == 0 )count++;
		}
		if(count>=K) return false;
		else return true;
	}
	public static int factory(int N, int K, int[] up, int[] down) {
		
		int stage = 0;
		boolean [] isRobot = new boolean[N]; //
		
		while(check(up,down,K)) {
		
			//1. 회전
			int tmpUp = down[0];
			int tmpDown = up[N-1];
			for (int i = 1; i <N ; i++) {
				up[N-i] = up[N-i-1];
				down[i-1] = down[i];
				isRobot[N-i] = isRobot[N-i-1];
			}
			up[0] = tmpUp;
			down[N-1] = tmpDown;
			isRobot[0] = false;
			
			// 하차
			isRobot[N-1] = false;
			
			//2. 로봇 이동
			for (int i = 1; i < N; i++) {
				if(up[N-i]>0 && isRobot[N-i-1] && !(isRobot[N-i])) {
					up[N-i] -- ;
					isRobot[N-i] = true;
					isRobot[N-i-1] = false;
				}
			}

			//3.올리는 위치 체크
			if(up[0]>0) {
				isRobot[0] = true;
				up[0] --;
			}
			stage++;
		}
		return stage;
	}
}
