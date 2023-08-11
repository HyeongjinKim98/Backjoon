import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		ArrayList<int[]> ar = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			ar.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		ar.sort(Comparator.comparingInt((int[] c)->c[0]));
		ar.sort(Comparator.comparingInt((int[] c)->c[1]));

		int end = 0;
		int res = 0;
		for (int[] is : ar) {
			if (is[0]>=end) {
				res++;
				end = is[1];
			}
		}
		System.out.println(res);
	}
}