import java.io.*;
public class Main {
	static void zip(int[][] map, int N,int si, int sj) {
		int sum = 0;
		if(N>0) {
			for (int i = si; i < si+N; i++) {
				for (int j = sj; j < sj+N; j++) {
					if(map[i][j]==1)sum++;
				}
			}
			if(sum == N*N) {
				 System.out.print(1);
				 return;
			}
			if(sum == 0) {
				System.out.print(0);
				return;
			}
			if(sum > 0 && sum < N*N) {
				System.out.print("(");
				zip(map,N/2,si    ,sj);  // 1
				zip(map,N/2,si    ,sj+N/2); //2
				zip(map,N/2,si+N/2,sj);  // 3
				zip(map,N/2,si+N/2,sj+N/2); //4
				System.out.print(")");
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = Character.getNumericValue(line.charAt(j));
		}
		zip(map,N,0,0);
	}
}