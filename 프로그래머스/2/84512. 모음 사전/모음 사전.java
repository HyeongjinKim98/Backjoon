class Solution{
    static int answer = 0;
    static boolean complete = false;
    static String[] vowels = {"A","E","I","O","U"};
    static void comb(String target, String word, int depth){
        if(depth>5){
            return;
        }
        if(target.equals(word)){
            complete = true;
            return;
        }
        for (int i = 0; i < 5; i++) {
            if(complete) return;
            if(depth < 5) answer ++;
            comb(target + vowels[i], word,depth +1);
        }
    }
    public int solution(String word){
        comb("", word,0);
        return answer;
    }
}