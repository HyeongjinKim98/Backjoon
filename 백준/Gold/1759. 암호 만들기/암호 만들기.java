import java.io.*;
import java.util.*;

public class Main{
	
	static boolean isVowel(char c) {
		return (c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u') ? true : false;
	}
	static String result(char[] c) {
		String res ="";
		for (int i = 0; i < c.length; i++) res += c[i];
		return res;
	}
	
	static void comb(char[] letters, int s, char[] pw, boolean[] v, int L, int C, int cnt, int a, int b) {
		char current = letters[s];
		pw[cnt] = current;
		if(isVowel(current)) a++; else b++;
		if(cnt == L-1) {
			if(a>=1 && b>=2) System.out.println(result(pw));
			return;
		}
		for (int i = s; i < C; i++) {
			if(!v[i]) {
				v[i] = true;
				comb(letters, i, pw, v, L, C, cnt+1, a, b);
				v[i] = false;
			}
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		char[] letters = new char[C];
		char[] pw = new char[L];
		boolean[] v= new boolean[C];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < C; i++) letters[i] = st.nextToken().charAt(0);
		
		Arrays.sort(letters);
		
		for (int i = 0; i < C; i++) {
			v[i] = true;
			comb(letters, i, pw, v, L, C, 0, 0, 0);
			v[i] = false;	
		}
	}
}
