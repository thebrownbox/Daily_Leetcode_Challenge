/**
 * @param {string[]} sentences
 * @return {number}
 */
 var mostWordsFound = function(strArr = ['']) {
    let maxCount = 0;
    strArr.forEach(s => maxCount = Math.max(maxCount, s.split(' ').length));
    return maxCount;
    // return strArr.reduce((prevMax, s) => Math.max(prevMax, s.split(' ').length), 0);
};