import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");;

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int dp[][] = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 1; j <= N; j++) {
				dp[i][j] = dp[i][j-1]+Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine()," ");
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int k = x1; k <= x2; k++)
				sum += (dp[k][y2] - dp[k][y1-1]);
			sb.append(sum+"\n");
		}
		System.out.print(sb);
	}
}