/**
 * @param {string[]} sentences
 * @return {number}
 */
 var mostWordsFound = function(sentences = []) {
    // const maxLen = 0;
    // sentences.forEach(str => maxLen = Math.max(maxLen, str.split(" ").length ));
    // return maxLen;

    return sentences.reduce( (prevMaxLen, str) => Math.max(prevMaxLen, str.split(' ').length), 0);
};