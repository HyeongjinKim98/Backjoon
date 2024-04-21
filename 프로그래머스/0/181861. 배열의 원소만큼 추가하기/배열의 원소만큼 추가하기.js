function solution(arr) {
    var answer = [];
    for(const num of arr){
        let n = Number(num);
        for(let i = 0; i<n; i++){
            answer.push(Number(n));
        }
    }
    return answer;
}