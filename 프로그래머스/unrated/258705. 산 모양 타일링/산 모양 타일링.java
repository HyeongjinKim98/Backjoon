class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int a[] = new int[n+1];
        int b[] = new int[n+1];
        a[0]= 1;
        for (int i = 0; i < n; i++) {
            if(tops[i]==1){
                a[i+1] = (a[i] *3 + b[i] *2)%10007;
            }else{
                a[i+1] = (a[i] *2 + b[i])%10007;
            }
            b[i+1] = (a[i] + b[i])%10007;
        }
        return (a[n] + b[n]) % 10007;
    }
}