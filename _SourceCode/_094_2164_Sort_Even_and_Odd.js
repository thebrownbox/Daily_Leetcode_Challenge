/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var sortEvenOdd = function(a = []) {
    const valuesAtOddIndex = a.filter((x, i) => i%2 !== 0);
    const valuesAtEvenIndex = a.filter((x, i) => i%2 === 0);

    valuesAtOddIndex.sort((a,b) => b-a);
    valuesAtEvenIndex.sort((a,b) => a-b);

    let j = 0, k = 0;
    for (let i = 0; i < a.length; i++) {
        if(i%2 !== 0){
            a[i] = valuesAtOddIndex[j++];
        }else{
            a[i] = valuesAtEvenIndex[k++];
        }
    }

    return a;
};