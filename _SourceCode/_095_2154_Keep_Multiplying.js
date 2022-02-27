/**
 * @param {number[]} nums
 * @param {number} original
 * @return {number}
 */
var findFinalValue = function(a = [], original) {
    while(a.includes(original)){
        original *= 2;
    }
    return original;
};