class Solution {
    public int solution(int a, int b, int n) {
        return recursion(a,b,n,0);
    }
    
    public int recursion(int a, int b, int n, int bottles){
        int bottle_get = n/a;
        if(bottle_get < 1){
            return bottles;
        }
        return recursion(a, b, n%a + bottle_get*b , bottles + bottle_get*b);
    }
}