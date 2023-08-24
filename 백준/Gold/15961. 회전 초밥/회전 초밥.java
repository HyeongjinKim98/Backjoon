import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int Res = 0;
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] v= new int[d+1];
		int[] sushi = new int[N];
		ArrayDeque<Integer> plate = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());
		int cnt = 0;
		boolean isCoupon = false;
		for (int i = 0; i < N+k-1; i++) {
			int input = sushi[i%N];
			plate.offer(input);
			if(v[input]==0) {
				cnt ++;
			}v[input] ++;
			
			if(plate.size() == k) {
				if(v[c]==0) {
					 isCoupon = true;
				}
//				System.out.printf(plate+" : "+ ((isCoupon)?cnt+1:cnt) + "\n");
//				System.out.println(Arrays.toString(v));
				Res = Math.max(Res, ((isCoupon)?cnt+1:cnt));
				int output = plate.poll();
				if(v[output]==1) {
					cnt--;
				}v[output] --;
				isCoupon = false;
			}
		}
		System.out.println(Res);
	}
}
