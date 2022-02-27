/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
 var countPairs = function(a, k) {
    let count = 0;
    for (let i = 0; i < a.length; i++) {
        for (let j = i+1; j < a.length; j++) {
            if(a[i] === a[j] && i*j % k === 0){
                count++;
            }
        }
    }
    return count;
};