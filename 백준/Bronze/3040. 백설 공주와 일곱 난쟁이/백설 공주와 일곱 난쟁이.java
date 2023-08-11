import java.io.*;

public class Main {
	
	static void Comb(int cnt, int start, int[] nje, int[] res) {
		if(cnt==7){
			int sum = 0;
			for (int i = 0; i < 7; i++) sum += res[i];
			if(sum==100) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 7; i++) sb.append(res[i]).append("\n");
				System.out.println(sb.toString());
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			res[cnt] = nje[i];
			Comb(cnt+1,i+1,nje,res);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nje = new int[9];
		int[] res = new int[7];
		for (int i = 0; i < 9; i++) nje[i] = Integer.parseInt(br.readLine());
		Comb(0,0,nje,res);
		br.close();
	}
}
