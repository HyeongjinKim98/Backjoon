class Solution {
    static String[] vowels = {"A","E","I","O","U"};
    
    public int solution(String word) {
        
        return comb("", word ,0);
    }
    
    static int comb(String target, String word, int cnt){
        if(word.equals(target)){
            return cnt;
        }
        for(int i = 0; i <5; i++){
            comb(target+vowels[i],word,cnt+1);
        }
        return 0;
    }
}