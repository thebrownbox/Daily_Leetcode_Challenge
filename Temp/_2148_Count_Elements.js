/**
 * @param {number[]} nums
 * @return {number}
 */
 var countElements = function(a = []) {
    const max = Math.max(...a);
    const min = Math.min(...a);
    return a.filter(x => x > min && x < max).length;
};