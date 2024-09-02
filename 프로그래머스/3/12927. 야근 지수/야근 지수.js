// works의 각 값에 n을 적절히 배분하여 빼줘서 w0^2 + w1^2 + ... 의 값을 최소로 만들기
// 가장 많은 일의 값을 빼야 유리 -> 정렬

const solution=(n, works)=>{
    
    if(works.reduce((sum,work) => sum += work,0)<=n) return 0;
    const last= works.length -1
    let answer = 0;
    let sorted = works.sort((a,b) => a-b);
    
    while(n>0){
        const max= sorted[last]
        
        for(let i= last; i>=0; i--){
            if(sorted[i] >= max){
                sorted[i] --;
                n--;
            }
            if(n==0) break;
        }
    }
    return sorted.reduce((result,work) => result + work*work,0)
}


