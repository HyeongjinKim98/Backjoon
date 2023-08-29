import java.util.*;
public class Main{
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] acc = new int[N+1];
		acc[0] = 1; acc[1] = 1;
		for (int i = 2; i <= N; i++) acc[i] =(acc[i-1] + acc[i-2])%10007;
		System.out.println(acc[N]);
		sc.close();
	}
}
