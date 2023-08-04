import java.util.*;
import java.util.stream.Stream;
import java.io.*;
public class Main{
	static int[] a  = {1,3,5,7,9}, aa = {2,3,5,7}, b;
	static int N = 5, R;

	static boolean isPrime(int num){
		for (int i = 2; i<=(int)Math.sqrt(num); i++) {
		      if (num % i == 0) return false;
			}
			return true;
	}
	static void isAnswer(int[] arr){
		int res= 0;
		boolean isAns = true;
		for (int i = 0; i < arr.length; i++) {
			res = res*10 + arr[i];
			if(!isPrime(res)) {
				 isAns = false;
				 break;
			}
		}
		if(isAns) System.out.println(res);
	}
	static void perm(int cnt) {
		if(cnt==R) {
			isAnswer(b);
			return;
		}
		if(cnt==0){
			for(int i = 0; i<4; i++){
				b[0] = aa[i];
				perm(1);
			}
		}else {
			for(int i = 0; i<N; i++){
				b[cnt] = a[i];
				perm(cnt+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		b = new int[R];
		perm(0);
		sc.close();
		
	}
}