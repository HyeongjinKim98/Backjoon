function solution(gems) {
        const map = new Map()
        const num_goal = [...new Set(gems)].length
        const answer_arr = [];

        gems.forEach((gem,index)=>{
            map.delete(gem)
            map.set(gem,index)
            if(map.size === num_goal)
                answer_arr.push([map.values().next().value+1, index+1])
        })

        return answer_arr.sort((a,b)=> (a[1]-a[0])-(b[1]-b[0]))[0] 
}