import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static char[] letters;
	static char[] pw;
	static boolean check(char[] pw) {
		int a  = 0, b = 0;
		for (char c : pw)
			if(c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u') a++;
			else b++;
		return (a >= 1 && b >= 2);
		
	}
	static void comb(int cnt, int s) {
		if(cnt == L) {
			if(check(pw)) {
				for (char c : pw) System.out.print(c);
				System.out.println();
			}
			return;
		}
		for (int i = s; i < C; i++) {
			pw[cnt] = letters[i];
			comb(cnt + 1, i + 1);
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		letters = new char[C];
		pw = new char[L];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < C; i++) letters[i] = st.nextToken().charAt(0);
		// 일단 정렬
		Arrays.sort(letters);
		
		comb(0,0);
	}
}
