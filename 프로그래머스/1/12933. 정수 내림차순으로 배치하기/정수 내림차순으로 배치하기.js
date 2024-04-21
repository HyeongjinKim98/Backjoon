function solution(n) {
    const str = n+"";
    const num = str.split("").sort().reverse().join("");
    return +num ;
}